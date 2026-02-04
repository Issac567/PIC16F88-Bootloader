B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Class
Version=9.85
@EndOfDesignText@
#Region Shared Files
'#CustomBuildAction: folders ready, %WINDIR%\System32\Robocopy.exe,"..\..\Shared Files" "..\Files"
'Ctrl + click to sync files: ide://run?file=%WINDIR%\System32\Robocopy.exe&args=..\..\Shared+Files&args=..\Files&FilesSync=True
#End Region

'VERSION 1.03

'Ctrl + click to export as zip: ide://run?File=%B4X%\Zipper.jar&Args=Project.zip

Sub Class_Globals
	Private Const START_ADDR_FLASH As Int = 0x0600			' Start Address of Flash
	Private Const END_ADDR_FLASH As Int = 0x0FFF			' End Address of Flash
	Private Const WORDS_PER_PACKET As Int = 4				' Total Word Per Packet for Write Block
	Private Const BLOCK_SIZE As Int = WORDS_PER_PACKET * 2 	' 4 words = 8 bytes per Write block
	Private Const PACKET_DELAY_MS As Int = 4				' Write Block Packet Delay 
	Private Const HANDSHAKE_DELAY_MS As Int = 200 			' Handshake Delay 
	Private Const MSB_WORD_ADDR As Int = 0x3F				' 14 bit word address MSB	
	Private Const EXPECTED_FIRMWARE_BYTES As Int = (END_ADDR_FLASH - START_ADDR_FLASH + 1) * 2
	
	Private serial1 As Serial								' UART COM
	Private astream As AsyncStreams
	
	Private Root As B4XView
	Private xui As XUI
	
	Private btnFlash As Button
	Private btnLoadFile As Button
	Private btnOpen As Button
	Private txtLog As TextArea
	Private cmbPort As ComboBox
	Private prgBar As ProgressBar

	
	Private firmware() As Byte								' firmware binary
	Private firmwareVerify(EXPECTED_FIRMWARE_BYTES) As Byte		' Incoming PIC bytes for verify
	Private cntVerify As Int								' Counter to detect number of incoming bytes from PIC
	Private blnVerifyRequest As Boolean						' Request verify from PIC
	Private blnProgrammingInProgress As Boolean				' For exit app msgbox while flashing
	Private bln16F88HandShakeSuccess As Boolean				' <InitReceived> from 16F88
	Private bln16F88ExitTimeoutError As Boolean				' <TimeoutError> from 16F88
	Private blnAppExitAstreamError	As Boolean				' Astream error exit loop from app
	Private blnAppStopQuit As Boolean						' Exit loop for Stop and Quit from app
	Private blnACK As Boolean								' Firmware Upload.  Needs this <ACK> from PIC to continue next 8 bytes
	
	Private rxBufferString As String						' Buffer Newdata in string format
	Private rxBuffer() As Byte								' Buffer Newdata in byte format 

End Sub

Public Sub Initialize
	serial1.Initialize("serial")
End Sub

'This event will be called once, before the page becomes visible.
Private Sub B4XPage_Created (Root1 As B4XView)
	Root = Root1
	Root.LoadLayout("MainPage")
	cmbPort.Items.AddAll(serial1.ListPorts)
	B4XPages.SetTitle(Me, "PIC16F88 Bootloader Upload")
	B4XPages.GetNativeParent(Me).WindowHeight = 700
	B4XPages.GetNativeParent(Me).WindowWidth = 600
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
'You can see the list of page related events in the B4XPagesManager object. The event name is B4XPage.

Sub AStream_NewData (Buffer() As Byte)
	' Append ASCII string for <…> parsing
	rxBufferString = rxBufferString & BytesToString(Buffer, 0, Buffer.Length, "UTF8")
	
	' Append raw bytes for verfiy firmware
	rxBuffer = AppendBytes(rxBuffer, Buffer)
	
	' Pic 16F88 sends with > as last byte to confirm end of message or bytes
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

	' Allocate new array
	Dim newArray(totalLength) As Byte

	' Copy old data
	Dim i As Int
	For i = 0 To OldBuffer.Length - 1
		newArray(i) = OldBuffer(i)
	Next
	
	Dim StartLen As Int = OldBuffer.Length

	' Copy new data
	For i = 0 To NewBuffer.Length - 1
		newArray(StartLen + i) = NewBuffer(i)
	Next

	Return newArray
End Sub
Sub HandleMessage(msg As String, buffer() As Byte)
	
	' Do this so Logmessage wont flood the log view only with <ACK> and Verify data (4 words at a time)
	If blnVerifyRequest = False And msg <> "<ACK>" Then
		LogMessage("PIC16F88", msg)
	End If
	
	Select Case msg
		' 0x55 and 0xAA received by PIC
		Case "<InitReceived>"
			bln16F88HandShakeSuccess = True
			LogMessage("Status", "PIC responded! Done sending 0x55 0xAA")
			
		' Timeout 3 times = error by PIC
		Case "<ErrorTimeout>"
			bln16F88ExitTimeoutError = True
			EnableButtons
			LogMessage("Status", "PIC reported timeout error, try again")
			
		' 1 second timeout.  if no handshake it will enter application
		Case "<HandShakeTimeout>"
			LogMessage("Status", "Timeout exiting bootloader --> entering application.")
			
		' Start of verify flash program code
		Case "<StartVerifyFlash>"
			cntVerify = 0
			blnVerifyRequest = True
			LogMessage("Status", "Waiting for Verification...")
			
		' End of verify flash program code
		Case "<EndVerifyFlash>"
			EnableButtons
			VerifyStatus
			
		' When Pic send this start the flash
		Case "<EndFlashErase>"
			Sleep(200)
			SendFirmware
		
		' B4J expects <ACK> from PIC so it sends next packets
		Case "<ACK>"
			blnACK = True
			
		Case Else
			' This is triggered by <StartVerifyFlash> from PIC after Flash Write
			If blnVerifyRequest = True Then
				'LogMessage("Incoming", BytesToHexString(buffer))  ' debugging only!!!
								
				'For x = 0 To buffer.Length - 1 - 1	' last buffer is ">" we dont include it.  OLD VERSION do not USE!!!
				For x = 0 To buffer.Length - 1  ' This method is better.  Newdata does not guarantee all block in one event
					' This array will compare to firmware() which is file binary
					
					firmwareVerify(cntVerify) = buffer(x)
										
					' Update progress bar
					prgBar.Progress = Min(1, cntVerify / EXPECTED_FIRMWARE_BYTES)
					cntVerify = cntVerify + 1
					
					' Check if we reached the expected firmware size
					If cntVerify >= EXPECTED_FIRMWARE_BYTES Then
						' Let <EndVerifyFlash> display the status of Verify!
						' Just enable button here
						EnableButtons
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
	EnableButtons
	LogMessage("Status", "Connection is broken.")
End Sub

Sub cmbPort_SelectedIndexChanged(Index As Int, Value As Object)
	btnOpen.Enabled = Index > -1 'enable the button if there is a selected item
End Sub

Sub btnOpen_Click
	
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

Private Sub btnLoadFile_Click
	firmware = Array As Byte() ' Resets to an empty array (length 0)
	Dim fc As FileChooser
	fc.Initialize
	fc.Title = "Intel Hex File Only!"
	Dim filepath As String
	filepath = fc.ShowOpen(B4XPages.GetNativeParent(Me))
   
	If filepath <> "" Then
		LogMessage("Status", "File Path: " & filepath)
		firmware = ConvertHexIntelToBinaryRange(filepath, START_ADDR_FLASH)
	Else
		LogMessage("Status", "No file selected.")
	End If
End Sub
Sub ConvertHexIntelToBinaryRange(filepath As String, startAddr As Int) As Byte()
	Dim lines As List = File.ReadList("", filepath)
    
	' Convert WORD address range → BYTE range
	Dim startByte As Int = startAddr * 2
    
	' Create binary array relative to startAddr
	Dim firmwareData(EXPECTED_FIRMWARE_BYTES) As Byte
    
	' LSB(0xFF) Then MSB(0x3F) format in binary
	For i = 0 To firmwareData.Length - 1 Step 2
		firmwareData(i) = 0xFF
		firmwareData(i+1) = MSB_WORD_ADDR			' 0x3F on PIC 16F88
	Next
    
	' Detect if type of intel hex
	Dim blnDetectRecordAvailable As Boolean = False
    
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
				blnDetectRecordAvailable = True
				'LogMessage(arrayIndex, Bit.ToHexString(b).ToUpperCase)
			End If
		Next
	Next
    
	' Status logging
	If blnDetectRecordAvailable Then
		btnFlash.Enabled = True
		LogMessage("Status", "Firmware bytes: " & firmwareData.Length)
	Else
		btnFlash.Enabled = False
		LogMessage("Status", "Conversion did not detect valid Intel HEX Record")
	End If
    
	Return firmwareData
End Sub

Private Sub btnFlash_Click
	If btnOpen.Text = "Open Port" Then
		xui.Msgbox2Async("Please choose and open port!", "Port Closed", "Ok", "", "", Null)
	Else
		If btnFlash.Text = "Flash" Then
			txtLog.Text = ""
			btnFlash.Text = "Stop"
			xui.Msgbox2Async("16F88 Application will restart to bootloader.  If not, then power off and on the PIC16F88.", "Attention!", "Ok", "", "", Null)				
			SendHandshakeLoop
		Else
			Dim sf6 As Object = xui.Msgbox2Async("Flash in progress!", "Stop?", "Yes", "", "No", Null)
			Wait For (sf6) Msgbox_Result(ret3 As Int)
				
			If ret3 = xui.DialogResponse_Positive Then
				LogMessage("Status", "User stop flash!")
				EnableButtons
			End If
		End If
	End If
End Sub
Sub SendHandshakeLoop
	' if not init
	If astream.IsInitialized = False Then
		LogMessage("SendHandshakeLoop", "Error Astream not initialized")
		Return
	End If
	
	Dim b() As Byte = Array As Byte(0x55)
	Dim b2() As Byte = Array As Byte(0xAA)
	Dim xTract As Int = 0
	
	DisableButtons
	
	Do While True
		' Status boolean
		If GetBooleanStatus = True Then Return
		
		' Exit and Start firmware upload if PIC signals handshake success
		If bln16F88HandShakeSuccess = True Then
			Return
		Else
			If xTract = 0 Then
				astream.Write(b)
				LogMessage("SendHandshakeLoop", "55")
			Else
				astream.Write(b2)
				LogMessage("SendHandshakeLoop", "AA")
			End If
		End If
				
		' Avoid flooding UART
		Sleep(HANDSHAKE_DELAY_MS)
		
		xTract = xTract + 1
		If xTract >= 2 Then xTract = 0
	Loop
End Sub
Sub SendFirmware
	' Firmware Binary file must be all flash data including empty address!
	
	Dim totalBlocks As Int = Ceil(firmware.Length / BLOCK_SIZE)
	Dim block(BLOCK_SIZE) As Byte

	LogMessage("FirmwareUpload", "Firmware size: " & firmware.Length & " bytes, total blocks: " & totalBlocks)

	For i = 0 To firmware.Length - 1 Step BLOCK_SIZE

		' Copy bytes into block with padding if last block is smaller
		Dim remaining As Int = firmware.Length - i
		Dim currentBlockSize As Int = Min(BLOCK_SIZE, remaining)
		        
		For j = 0 To BLOCK_SIZE - 1
			If j < currentBlockSize Then
				' Copy firmware bytes into block
				block(j) = firmware(i + j)
			Else
				' Copy remaining padding if needed
				block(j) = 0xFF	' Pic 16F88 MSB is 0x3F but 0xFF. Upper 2 bits ignored
			End If
		Next
		
		' Status boolean
		If GetBooleanStatus = True Then Return

		Do While blnACK = False
			' Status boolean
			If GetBooleanStatus = True Then Return
			
			Sleep(0)
		Loop
		
		' Send each byte with minimum 2 ms delay
		For x = 0 To BLOCK_SIZE - 1
			Dim b(1) As Byte       				' single-byte array
			b(0) = block(x)        				' copy current byte
			astream.Write(b)       				' send the byte
			Sleep(PACKET_DELAY_MS) 			   	' small delay between bytes
		Next
		
		' Update progress bar
		prgBar.Progress = Min(1, (i + BLOCK_SIZE) / firmware.Length)
		
		'Reset this
		blnACK = False
		
	Next
	
	LogMessage("FirmwareUpload", "Firmware upload completed!")


End Sub
Sub GetBooleanStatus As Boolean
	' Pic 16f88 reported timeout error (Handshake does not have this!)
	If bln16F88ExitTimeoutError = True Then
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

Sub DisableButtons
	btnOpen.Enabled = False
	btnLoadFile.Enabled = False
	cmbPort.Enabled = False
	cntVerify = 0
	blnProgrammingInProgress = True
	btnFlash.Text = "Stop"
	blnAppStopQuit = False
	bln16F88HandShakeSuccess = False
	bln16F88ExitTimeoutError = False
	blnAppExitAstreamError = False
	'B4XPages.GetNativeParent(Me).Resizable = False
End Sub
Sub EnableButtons
	btnOpen.Enabled = True
	btnLoadFile.Enabled = True
	cmbPort.Enabled = True
	blnVerifyRequest = False
	blnProgrammingInProgress = False
	btnFlash.Text = "Flash"
	blnAppStopQuit = True
	blnACK = False
	'B4XPages.GetNativeParent(Me).Resizable = True
End Sub

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
