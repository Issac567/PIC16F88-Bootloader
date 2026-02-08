B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@

'VERSION 2.01

'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=Project.zip

Sub Class_Globals
	Private StartAddrFlash As Int 
	Private EndAddrFlash   As Int
	Private MSBWordAddr As Int
	Private WordsPerPacket As Int
	Private PacketDelayMS As Int
	Private HandShakeDelayMS As Int
	Private UseWriteBurst  As Boolean						' Not ready
	
	Private ExpectedFirmwareBytes As Int
	Private BlockSize As Int

	Private serial1 As Serial								' UART COM
	Private astream As AsyncStreams							' Read/Write Stream
	
	Private Root As B4XView
	Private xui As XUI
	
	Private btnFlash As Button
	Private btnLoadFile As Button
	Private btnOpen As Button
	Private txtLog As TextArea
	Private cmbPort As ComboBox
	Private cmbPicList As ComboBox
	Private prgBar As ProgressBar

	
	Private firmware() As Byte								' firmware binary from FILE
	Private firmwareVerify() As Byte						' firmware binary from PIC
	Private cntVerify As Int								' Counter detection of incoming bytes from PIC
	Private blnProgrammingInProgress As Boolean				' For exit app msgbox while flashing
	Private blnVerifyRequest As Boolean						' <StartVerifyFlash> from PIC
	Private blnHandShakeSuccess As Boolean					' <InitReceived> from PIC
	Private blnExitTimeoutError As Boolean					' <TimeoutError> from PIC
	Private blnAppExitAstreamError	As Boolean				' Astream error exit loop from app
	Private blnAppStopQuit As Boolean						' Exit loop for Stop and Quit from app
	Private blnACK As Boolean								' <ACK> from PIC used in Firmware Upload.  Needs this <ACK> from PIC to continue next Block Write bytes
	
	Private rxBufferString As String						' Buffer Newdata in string format
	Private rxBuffer() As Byte								' Buffer Newdata in byte format 

	Private LastFilePath As String							' Reloads firmware from FILE when PIC name changed so Firmware array be corrected
	

End Sub

Public Sub Initialize
	serial1.Initialize("serial")
End Sub

'--------------------------------------------------------
'This event will be called once, before the page becomes visible.
'--------------------------------------------------------
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
		
	B4XPages.SetTitle(Me, "PIC Bootloader Upload")
	B4XPages.GetNativeParent(Me).WindowHeight = 700
	B4XPages.GetNativeParent(Me).WindowWidth = 600
	
	' Load all available COM Ports
	cmbPort.Items.AddAll(serial1.ListPorts)
	
	' Load PIC names from map files
	Dim getList As List = LoadAllPicNames
	For Each name As String In getList
		cmbPicList.Items.Add(name)
	Next
	
	' Set prompt text for combo box
	Dim jo As JavaObject = cmbPort
	jo.RunMethod("setPromptText", Array("Choose Port"))
	Dim jo As JavaObject = cmbPicList
	jo.RunMethod("setPromptText", Array("PIC List"))
	
End Sub
Private Sub B4XPage_CloseRequest As ResumableSub
	
	' Flash in progress alert user!
	If blnProgrammingInProgress = True Then
		Dim sf4 As Object = xui.Msgbox2Async("Flash in progress!", "Quit?", "Yes", "", "No", Null)
		Wait For (sf4) Msgbox_Result(ret3 As Int)
				
		If ret3 = xui.DialogResponse_Negative Then
			Return False  ' will not exit
		End If
	End If
	
	' Close them when exiting!
	If astream.IsInitialized Then 		
		astream.Close
		serial1.Close
	End If
		
	Return True	
End Sub

'--------------------------------------------------------
' Astream Functions
'--------------------------------------------------------
Sub AStream_NewData (Buffer() As Byte)	
	' Option display Hex for Debugging!
'	Dim AddHexView As String = BytesToHexString(Buffer).ToUpperCase
'	LogMessage("Hex", AddHexView)
	
	' Append ASCII string for <…> parsing
	rxBufferString = rxBufferString & BytesToString(Buffer, 0, Buffer.Length, "UTF8") 
	
	' Append raw bytes for verfiy firmware (stricktly bytes only!)
	rxBuffer = AppendBytes(rxBuffer, Buffer)

	' PIC sends with > as last byte to confirm end of message or bytes
	' When VerifyRequest = true, it does not received ">". Sticktly bytes only!
	If rxBufferString.Contains(">") Or blnVerifyRequest = True Then
		HandleMessage(rxBufferString, rxBuffer)
		rxBufferString = ""
		rxBuffer = Array As Byte() ' Resets to an empty array (length 0)
	End If
	
End Sub
Sub AppendBytes(OldBuffer() As Byte, NewBuffer() As Byte) As Byte()
	' Total length = old + new
	Dim totalLength As Int = OldBuffer.Length + NewBuffer.Length
	If totalLength = 0 Then Return Array As Byte() ' nothing to append

	' Allocate new array (Old + New total)
	Dim newArray(totalLength) As Byte

	' Copy old data to newArray()
	Dim i As Int
	For i = 0 To OldBuffer.Length - 1
		newArray(i) = OldBuffer(i)
	Next
	
	Dim StartLen As Int = OldBuffer.Length

	' Copy new data to newArray()
	For i = 0 To NewBuffer.Length - 1
		newArray(StartLen + i) = NewBuffer(i)
	Next

	Return newArray
End Sub
Sub HandleMessage(msg As String, buffer() As Byte)
	
	' We dont want to log Incoming <ACK> while Firmware upload!
	' We dont want to log Incoming PIC bytes for verify
	If blnVerifyRequest = False And msg <> "<ACK>" Then
		LogMessage("PIC", msg)
	End If
	
	Select Case msg
		' 0x55 and 0xAA received by PIC
		Case "<InitReceived>"
			blnHandShakeSuccess = True
			LogMessage("Status", "PIC responded! Done sending 0x55 0xAA")
			
		' Timeout 3 times = error by PIC
		Case "<ErrorTimeout>"
			blnExitTimeoutError = True
			EnableFunction
			LogMessage("Status", "PIC reported timeout error, try again")
			
		' 3 seconds timeout.  if no handshake it will enter application
		Case "<HandShakeTimeout>"
			LogMessage("Status", "Timeout exiting bootloader --> entering application.")
			
		' Start of verify flash program code
		Case "<StartVerifyFlash>"
			cntVerify = 0
			blnVerifyRequest = True
			LogMessage("Status", "Waiting for Verification...")
			
		' End of verify flash program code
		Case "<EndVerifyFlash>"
			EnableFunction
			VerifyStatus
			
		' End of Erase Flash. When Pic send this delay a bit and start the flash upload
		Case "<EndFlashErase>"
			Sleep(200)
			SendFirmware
		
		' B4J expects <ACK> from PIC so it sends next packets in Firmware Upload routine
		Case "<ACK>"
			blnACK = True
			
		Case Else
			' This is triggered by <StartVerifyFlash> from PIC after Flash Write is completed
			If blnVerifyRequest = True Then
				'LogMessage("Incoming", BytesToHexString(buffer))  ' debugging only!!!
								
				For x = 0 To buffer.Length - 1  ' This method is better.  Newdata does not guarantee all block in one event
					' This array will compare to firmware() which is Converted FILE binary
					firmwareVerify(cntVerify) = buffer(x)
										
					' Update progress bar
					prgBar.Progress = Min(1, cntVerify / ExpectedFirmwareBytes)
					cntVerify = cntVerify + 1
					
					' Check if we reached the expected firmware size
					If cntVerify >= ExpectedFirmwareBytes Then
						' Let <EndVerifyFlash> display the status of Verify!
						' Just enable button here
						EnableFunction
						Exit
					End If
				Next
			End If
			
	End Select
End Sub
Sub AStream_Error
	LogMessage("Status", "Error: " & LastException)
	AStream_Terminated
End Sub
Sub AStream_Terminated
	blnAppExitAstreamError = True
	
	If astream.IsInitialized Then
		astream.Close
		serial1.Close
	End If
	EnableFunction
	LogMessage("Status", "Connection is broken.")
End Sub

'--------------------------------------------------------
' Buttons and Combo Box functions
'--------------------------------------------------------
Private Sub cmbPort_SelectedIndexChanged(Index As Int, Value As Object)
	btnOpen.Enabled = Index > -1 'enable the button if there is a selected item
End Sub

Private Sub cmbPicList_SelectedIndexChanged(Index As Int, Value As Object)
	If LoadConfiguration(Value) = False Then
		LogMessage("Config", "Error loading configuration for " & Value)
	End If
End Sub

Private Sub btnOpen_Click
	
	' Open Port (57600 Baud)
	If btnOpen.Text = "Open Port" Then
		Try
			serial1.Open(cmbPort.Value)
			serial1.SetParams(serial1.BAUDRATE_57600, serial1.DATABITS_8, serial1.STOPBITS_1, serial1.PARITY_NONE)  ' Set baud=57600, 8 data bits, 1 stop bit, no parity
			astream.Initialize(serial1.GetInputStream, serial1.GetOutputStream, "astream")
		Catch
			LogMessage("Status", "Error Open Port" & LastException)
			Return
		End Try
		btnOpen.Text = "Close Port"
		LogMessage("Status", "Port Opened")
		
	' Close Port
	Else
		If astream.IsInitialized Then
			astream.Close
			serial1.Close
		End If
		btnOpen.Text = "Open Port"
		LogMessage("Status", "Port Closed")
	End If
End Sub

'--------------------------------------------------------
' Load Intel Hex file and convert it to binary (LSB->MSB)
'--------------------------------------------------------
Private Sub btnLoadFile_Click
	If cmbPicList.SelectedIndex = -1 Then
		xui.Msgbox2Async("Please select PIC Name from the list!  Conversion requires PIC configuration input!", "PIC Name?", "Ok", "", "", Null)
		Return
	End If
	
	' Init File Chooser
	Dim fc As FileChooser
	fc.Initialize
	fc.Title = "Intel Hex File Only!"
	
	' Add Intel Hex filter only!
	Dim l As List
	l.Initialize
	l.Add("*.hex")
	fc.SetExtensionFilter("Intel Hex", l)
	
	' Get File Path
	Dim filepath As String
	filepath = fc.ShowOpen(B4XPages.GetNativeParent(Me))
   
	If filepath <> "" Then
		LastFilePath = filepath
		LogMessage("Status", "File Path: " & filepath)	
		firmware = ConvertHexIntelToBinaryRange(filepath, StartAddrFlash)
	Else
		LastFilePath = ""
		LogMessage("Status", "No file selected.")
	End If
End Sub
Sub ConvertHexIntelToBinaryRange(filepath As String, startAddr As Int) As Byte()
	Try
		
		Dim lines As List = File.ReadList("", filepath)
	    
		Dim startByte As Int = startAddr * 2
	    
		' Create binary array relative to startAddr
		Dim firmwareData(ExpectedFirmwareBytes) As Byte
	    
		' LSB(0xFF) Then MSB(0x3F) format in binary Firmware()
		For i = 0 To firmwareData.Length - 1 Step 2
			firmwareData(i) = 0xFF
			firmwareData(i+1) = MSBWordAddr			' 0x3F on PIC
		Next
	    
		' Detect if type of intel hex
		Dim blnDetectRecord As Boolean = False
	    
		firmware = Array As Byte() ' Resets to an empty array (length 0)
		
		' Process each HEX line
		For Each line As String In lines
			If line.Length = 0 Or line.CharAt(0) <> ":" Then Continue
	        
			Dim byteCount As Int = Bit.ParseInt(line.SubString2(1, 3), 16)
			Dim wordAddr As Int = Bit.ParseInt(line.SubString2(3, 7), 16)
			Dim recordType As Int = Bit.ParseInt(line.SubString2(7, 9), 16)
	        
			' Only data records
			If recordType <> 0 Then Continue
	        
			Dim byteAddr As Int = wordAddr
	        
			For i = 0 To byteCount - 1
				Dim b As Int = Bit.ParseInt(line.SubString2(9 + i * 2, 11 + i * 2), 16)
				Dim arrayIndex As Int = byteAddr - startByte + i
	            
				' Only write if within requested range
				If arrayIndex >= 0 And arrayIndex < firmwareData.Length Then
					firmwareData(arrayIndex) = b
					blnDetectRecord = True
					'LogMessage(arrayIndex, Bit.ToHexString(b).ToUpperCase)
				End If
			Next
		Next
	    
		' Status logging
		If blnDetectRecord Then
			btnFlash.Enabled = True
			LogMessage("Status", "Firmware conversion completed, binary arrays: " & firmwareData.Length & " bytes")
		Else
			btnFlash.Enabled = False
			LogMessage("Status", "Did not detect valid Intel HEX Record")
		End If
	    
		Return firmwareData
	
	Catch
		Dim EmptyArr() As Byte = Array As Byte()
		xui.Msgbox2Async("Error occurred! " & LastException, "Error", "Ok", "", "", Null)
		Return EmptyArr
	End Try
End Sub

'--------------------------------------------------------
' Start Handshake and Flash Upload
'--------------------------------------------------------
Private Sub btnFlash_Click
	
	' Validation Checks
	If btnOpen.Text = "Open Port" Then
		xui.Msgbox2Async("Please choose and open port!", "Port Closed", "Ok", "", "", Null)
	' Validation Checks
	Else If cmbPicList.Items.Size = 0 Then
		xui.Msgbox2Async("Configuration is missing!", "Configuration", "Ok", "", "", Null)
	' Flashing Logic
	Else If btnFlash.Text = "Flash" Then
		Dim sf2 As Object = xui.Msgbox2Async("If the PIC application is running, it will enter bootloader mode automatically. " & _
  											 "If not, please click OK and then power cycle (turn off and on) your microchip to enter bootloader mode.", _
                                      		 "Attention!", "Ok", "Cancel", "", Null)
		Wait For (sf2) Msgbox_Result(ret As Int)
		If ret = xui.DialogResponse_Positive Then
			SendHandshakeLoop
		End If
	' Flash Stop Logic
	Else
		Dim sf3 As Object = xui.Msgbox2Async("Flash in progress!", "Stop?", "Yes", "", "No", Null)
		Wait For (sf3) Msgbox_Result(ret2 As Int)		
		If ret2 = xui.DialogResponse_Positive Then
			LogMessage("Status", "User stop flash!")
			EnableFunction
		End If
	End If

End Sub
Sub SendHandshakeLoop
	' Just to be sure if initialized!
	If astream.IsInitialized = False Then
		EnableFunction
		LogMessage("Handshake", "Error Astream not initialized")
		Return
	End If
	
	Dim b() As Byte = Array As Byte(0x55)
	Dim b2() As Byte = Array As Byte(0xAA)
	Dim xTract As Int = 0
	
	DisableFunction
	
	Do While True
		' Status boolean
		If GetBooleanStatus = True Then Return
		
		' Exit and Start firmware upload if PIC signals handshake success
		If blnHandShakeSuccess = True Then
			Return
		Else
			If xTract = 0 Then
				astream.Write(b)
				LogMessage("Handshake", "Sending byte: 0x55")
			Else
				astream.Write(b2)
				LogMessage("Handshake", "Sending byte: 0xAA")
			End If
		End If
				
		' Avoid flooding UART
		Sleep(HandShakeDelayMS)
		
		xTract = xTract + 1
		If xTract >= 2 Then xTract = 0
	Loop
End Sub
Sub SendFirmware
	' Firmware Binary file must be all flash data including empty address!
	
	Dim totalBlocks As Int = Ceil(firmware.Length / BlockSize)
	Dim block(BlockSize) As Byte

	LogMessage("FirmwareUpload", "Firmware size: " & firmware.Length & " bytes, total blocks: " & totalBlocks & ", bytes/block: " & BlockSize)

	For i = 0 To firmware.Length - 1 Step BlockSize

		' Copy bytes into block with padding if last block is smaller
		Dim remaining As Int = firmware.Length - i
		Dim currentBlockSize As Int = Min(BlockSize, remaining)
		        
		For j = 0 To BlockSize - 1
			If j < currentBlockSize Then
				' Copy firmware bytes into block
				block(j) = firmware(i + j)
			Else
				' Copy remaining padding if needed
				block(j) = 0xFF	' PIC MSB is 0x3F but 0xFF. Upper 2 bits ignored when writing!
			End If
		Next
		
		' Status boolean
		If GetBooleanStatus = True Then Return

		Do While blnACK = False
			' Status boolean
			If GetBooleanStatus = True Then Return
			
			Sleep(0)
		Loop
		
		'Reset this
		blnACK = False
		
		' Send each byte with minimum 2 ms delay
		For x = 0 To BlockSize - 1
			Dim b(1) As Byte       				' single-byte array
			b(0) = block(x)        				' copy current byte
			astream.Write(b)       				' send the byte
			Sleep(PacketDelayMS) 			   	' small delay between bytes
		Next
		
		' Update progress bar
		prgBar.Progress = Min(1, (i + BlockSize) / firmware.Length)

	Next
	
	LogMessage("FirmwareUpload", "Firmware upload completed!")


End Sub
Sub GetBooleanStatus As Boolean
	' PIC reported timeout error (Handshake does not have this!)
	If blnExitTimeoutError = True Then
		Return True
	End If
		
	' Astream error or terminated
	If blnAppExitAstreamError = True Then
		Return True
	End If
		
	' Stop or Quit Detected
	If blnAppStopQuit = True Then
		Return True
	End If
	
	Return False
End Sub

'--------------------------------------------------------
' Verify Firmware
'--------------------------------------------------------
Sub VerifyStatus
	If VerifyFirmware = True Then
		LogMessage("Status", "Programming/Verify Success")
	Else
		LogMessage("Status", "Programming/Verify Failed!")
	End If
End Sub
Sub VerifyFirmware() As Boolean
	' Make sure both arrays are the same length
	If firmware.Length <> firmwareVerify.Length Then
		Return False
	End If

	' Compare byte by byte
	For i = 0 To firmware.Length - 1
		If firmware(i) <> firmwareVerify(i) Then
			LogMessage("Status", "Mismatch at byte " & i & _
                       ": firmware = " & BytesToHexString2(firmware(i)) & _
                       " vs verify = " & BytesToHexString2(firmwareVerify(i)))
			Return False
		End If
	Next

	' All bytes match
	Return True
End Sub

'--------------------------------------------------------
' Disable/Enable
'--------------------------------------------------------
Sub DisableFunction
	btnOpen.Enabled = False
	btnLoadFile.Enabled = False
	cmbPort.Enabled = False
	cmbPicList.Enabled = False
	cntVerify = 0
	blnProgrammingInProgress = True
	btnFlash.Text = "Stop"
	blnAppStopQuit = False
	blnHandShakeSuccess = False
	blnExitTimeoutError = False
	blnAppExitAstreamError = False
	txtLog.Text = ""
End Sub
Sub EnableFunction
	btnOpen.Enabled = True
	btnLoadFile.Enabled = True
	cmbPort.Enabled = True
	cmbPicList.Enabled = True
	blnVerifyRequest = False
	blnProgrammingInProgress = False
	btnFlash.Text = "Flash"
	blnAppStopQuit = True
	blnACK = False
End Sub

'--------------------------------------------------------
' Load all Map files in /configs and return PicName list
'--------------------------------------------------------
Sub LoadAllPicNames() As List
	Dim picList As List
	picList.Initialize
    
	' Make sure folder exists
	If File.Exists(File.DirApp, "configs") = False Then
		LogMessage("Config", "Missing configs directory, creating one!")
		File.MakeDir(File.DirApp, "configs")
		Return picList ' empty list
	End If
    
	' Get all files in configs folder
	Dim cfgDir As String = File.Combine(File.DirApp, "configs")
	Dim files As List = File.ListFiles(cfgDir)
    
	For Each f As String In files
		If f.ToLowerCase.EndsWith(".map") Then
			Try
				Dim cfg As Map = File.ReadMap(cfgDir, f)
				If cfg.ContainsKey("PicName") Then
					picList.Add(cfg.Get("PicName"))
				Else
					' fallback to filename if PicName missing
					LogMessage("Config", "Missing Pic Name - " & f)
				End If
			Catch
				' skip files that fail to load
				Log(LastException.Message)
			End Try
		End If
	Next
    
	Return picList
End Sub
Sub LoadConfiguration(SelectedPicName As String) As Boolean
	Dim cfgDir As String = File.Combine(File.DirApp, "configs")
	Dim picList As List
	picList.Initialize
    
	' Make sure folder exists
	If File.Exists(File.DirApp, "configs") = False Then
		Return False
	End If
    
	' Get all files in configs folder
	Dim files As List = File.ListFiles(cfgDir)
    
	For Each f As String In files
		If f.ToLowerCase.EndsWith(".map") Then
			Try
				Dim cfg As Map = File.ReadMap(cfgDir, f)
				If cfg.ContainsKey("PicName") Then
					Dim CheckName As String = cfg.Get("PicName")
					If CheckName = SelectedPicName Then
						txtLog.Text = ""
						
						StartAddrFlash = cfg.Get("StartAddrFlash")		' Start Address of Flash
						EndAddrFlash = cfg.Get("EndAddrFlash")			' End Address of Flash
						WordsPerPacket = cfg.Get("WordsPerPacket")		' Total Word Per Packet for Write Block
						PacketDelayMS = cfg.Get("PacketDelayMS")		' Write Block Packet Delay
						HandShakeDelayMS = cfg.Get("HandShakeDelayMS")	' Handshake Delay
						MSBWordAddr = cfg.Get("MSBWordAddr")			' 14 bit word address MSB
						UseWriteBurst = cfg.Get("UseWriteBurst")
						
						BlockSize = WordsPerPacket * 2					' eg. 4 words = 8 bytes per Write block
						ExpectedFirmwareBytes = (EndAddrFlash - StartAddrFlash + 1) * 2
						
						' Set Proper Arrays to FirmwareVerfiy()
						firmwareVerify = Array As Byte()
						Dim temp(ExpectedFirmwareBytes) As Byte
						firmwareVerify = temp
						
						' Make sure reload the Intel Hex file to new Firmware() array
						If LastFilePath <> "" Then
							firmware = ConvertHexIntelToBinaryRange(LastFilePath, StartAddrFlash)
						End If
						
						LogMessage("", "---------------------------------------------------------")
						LogMessage("", "CONFIGURATION FOR " & CheckName)
						LogMessage("", "---------------------------------------------------------")
						LogMessage(":::", "Start Address = 0x" & Bit.ToHexString(StartAddrFlash).ToUpperCase)
						LogMessage(":::", "End Address = 0x" & Bit.ToHexString(EndAddrFlash).ToUpperCase)
						LogMessage(":::", "Unimplemented Memory = 0x" & Bit.ToHexString(MSBWordAddr).ToUpperCase)
						LogMessage(":::", "HandShake Delay = " & HandShakeDelayMS & " ms")
						LogMessage(":::", "Packet Delay = " & PacketDelayMS & "ms")
						
						LogMessage("", "Block Write Size = " & (BlockSize/2) & " word (" & BlockSize & " bytes)")
						LogMessage("", "Expected Firmware Size = " & (ExpectedFirmwareBytes/2) & " word (" & ExpectedFirmwareBytes & " bytes)")
						LogMessage("", "---------------------------------------------------------")
  						Return True
					End If			
				End If
			Catch
				' skip files that fail to load
				Log(LastException.Message)
			End Try
		End If
	Next
	
	Return False
    
End Sub

'--------------------------------------------------------
' Log Message
'--------------------------------------------------------
Sub LogMessage(From As String, Msg As String)
	' Clear if exceeded
	'If txtLog.Text.Length > 15000 Then
	'	txtLog.Text = ""
	'End If
	txtLog.Text = txtLog.Text & From & ": " & Msg & CRLF
	txtLog.SetSelection(txtLog.Text.Length, txtLog.Text.Length)
End Sub
Sub BytesToHexString(b() As Byte) As String
	Dim sb As StringBuilder
	sb.Initialize
	For Each bt As Byte In b
		Dim byteString As String
		byteString = Bit.ToHexString(Bit.And(bt, 0xFF))
		If byteString.Length = 1 Then byteString = "0" & byteString
		sb.Append(byteString).Append(" ")
	Next
	Return sb.ToString.Trim.ToUpperCase
End Sub
Sub BytesToHexString2(b As Byte) As String
	Dim byteString As String

	byteString = Bit.ToHexString(Bit.And(b, 0xFF))
	If byteString.Length = 1 Then byteString = "0" & byteString
	
	Return byteString.ToUpperCase
End Sub

