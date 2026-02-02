package b4j.example;

import anywheresoftware.b4a.debug.*;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.B4AClass;

public class b4xmainpage extends B4AClass.ImplB4AClass implements BA.SubDelegator{
    public static java.util.HashMap<String, java.lang.reflect.Method> htSubs;
    private void innerInitialize(BA _ba) throws Exception {
        if (ba == null) {
            ba = new  anywheresoftware.b4a.shell.ShellBA("b4j.example", "b4j.example.b4xmainpage", this);
            if (htSubs == null) {
                ba.loadHtSubs(this.getClass());
                htSubs = ba.htSubs;
            }
            ba.htSubs = htSubs;
             
        }
        if (BA.isShellModeRuntimeCheck(ba))
                this.getClass().getMethod("_class_globals", b4j.example.b4xmainpage.class).invoke(this, new Object[] {null});
        else
            ba.raiseEvent2(null, true, "class_globals", false);
    }

 
    public void  innerInitializeHelper(anywheresoftware.b4a.BA _ba) throws Exception{
        innerInitialize(_ba);
    }
    public Object callSub(String sub, Object sender, Object[] args) throws Exception {
        return BA.SubDelegator.SubNotFound;
    }
public anywheresoftware.b4a.keywords.Common __c = null;
public int _start_addr_flash = 0;
public int _end_addr_flash = 0;
public int _words_per_packet = 0;
public int _block_size = 0;
public int _packet_delay_ms = 0;
public int _handshake_delay_ms = 0;
public int _msb_word_addr = 0;
public int _expected_firmware_bytes = 0;
public anywheresoftware.b4j.serial.Serial _serial1 = null;
public anywheresoftware.b4a.randomaccessfile.AsyncStreams _astream = null;
public anywheresoftware.b4j.object.JavaObject _jframe = null;
public anywheresoftware.b4a.objects.B4XViewWrapper _root = null;
public anywheresoftware.b4a.objects.B4XViewWrapper.XUI _xui = null;
public anywheresoftware.b4j.objects.ButtonWrapper _btnflash = null;
public anywheresoftware.b4j.objects.ButtonWrapper _btnloadfile = null;
public anywheresoftware.b4j.objects.ButtonWrapper _btnopen = null;
public anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper _txtlog = null;
public anywheresoftware.b4j.objects.ComboBoxWrapper _cmbport = null;
public anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper _prgbar = null;
public byte[] _firmware = null;
public byte[] _firmwareverify = null;
public int _cntverify = 0;
public boolean _blnverifyrequest = false;
public boolean _blnprogramminginprogress = false;
public boolean _bln16f88handshakesuccess = false;
public boolean _bln16f88exittimeouterror = false;
public boolean _blnappexitastreamerror = false;
public boolean _blnappstopquit = false;
public String _rxbufferstring = "";
public byte[] _rxbuffer = null;
public b4j.example.main _main = null;
public b4j.example.b4xpages _b4xpages = null;
public b4j.example.b4xcollections _b4xcollections = null;
public byte[]  _appendbytes(b4j.example.b4xmainpage __ref,byte[] _target,byte[] _data) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "appendbytes", false))
	 {return ((byte[]) Debug.delegate(ba, "appendbytes", new Object[] {_target,_data}));}
int _totallength = 0;
byte[] _newarray = null;
int _i = 0;
int _startlen = 0;
RDebugUtils.currentLine=786432;
 //BA.debugLineNum = 786432;BA.debugLine="Sub AppendBytes(target() As Byte, data() As Byte)";
RDebugUtils.currentLine=786434;
 //BA.debugLineNum = 786434;BA.debugLine="Dim totalLength As Int = target.Length + data.Len";
_totallength = (int) (_target.length+_data.length);
RDebugUtils.currentLine=786435;
 //BA.debugLineNum = 786435;BA.debugLine="If totalLength = 0 Then Return Array As Byte() '";
if (_totallength==0) { 
if (true) return new byte[]{};};
RDebugUtils.currentLine=786438;
 //BA.debugLineNum = 786438;BA.debugLine="Dim newArray(totalLength) As Byte";
_newarray = new byte[_totallength];
;
RDebugUtils.currentLine=786444;
 //BA.debugLineNum = 786444;BA.debugLine="Dim i As Int";
_i = 0;
RDebugUtils.currentLine=786445;
 //BA.debugLineNum = 786445;BA.debugLine="For i = 0 To target.Length - 1";
{
final int step5 = 1;
final int limit5 = (int) (_target.length-1);
_i = (int) (0) ;
for (;_i <= limit5 ;_i = _i + step5 ) {
RDebugUtils.currentLine=786446;
 //BA.debugLineNum = 786446;BA.debugLine="newArray(i) = target(i)";
_newarray[_i] = _target[_i];
 }
};
RDebugUtils.currentLine=786449;
 //BA.debugLineNum = 786449;BA.debugLine="Dim StartLen As Int = target.Length";
_startlen = _target.length;
RDebugUtils.currentLine=786452;
 //BA.debugLineNum = 786452;BA.debugLine="For i = 0 To data.Length - 1";
{
final int step9 = 1;
final int limit9 = (int) (_data.length-1);
_i = (int) (0) ;
for (;_i <= limit9 ;_i = _i + step9 ) {
RDebugUtils.currentLine=786453;
 //BA.debugLineNum = 786453;BA.debugLine="newArray(StartLen + i) = data(i)";
_newarray[(int) (_startlen+_i)] = _data[_i];
 }
};
RDebugUtils.currentLine=786456;
 //BA.debugLineNum = 786456;BA.debugLine="Return newArray";
if (true) return _newarray;
RDebugUtils.currentLine=786457;
 //BA.debugLineNum = 786457;BA.debugLine="End Sub";
return null;
}
public String  _astream_error(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "astream_error", false))
	 {return ((String) Debug.delegate(ba, "astream_error", null));}
RDebugUtils.currentLine=917504;
 //BA.debugLineNum = 917504;BA.debugLine="Sub AStream_Error";
RDebugUtils.currentLine=917505;
 //BA.debugLineNum = 917505;BA.debugLine="LogMessage(\"Status\", \"Error: \" & LastException)";
__ref._logmessage /*String*/ (null,"Status","Error: "+BA.ObjectToString(__c.LastException(ba)));
RDebugUtils.currentLine=917506;
 //BA.debugLineNum = 917506;BA.debugLine="AStream_Terminated";
__ref._astream_terminated /*String*/ (null);
RDebugUtils.currentLine=917507;
 //BA.debugLineNum = 917507;BA.debugLine="End Sub";
return "";
}
public String  _logmessage(b4j.example.b4xmainpage __ref,String _from,String _msg) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "logmessage", false))
	 {return ((String) Debug.delegate(ba, "logmessage", new Object[] {_from,_msg}));}
RDebugUtils.currentLine=1835008;
 //BA.debugLineNum = 1835008;BA.debugLine="Sub LogMessage(From As String, Msg As String)";
RDebugUtils.currentLine=1835014;
 //BA.debugLineNum = 1835014;BA.debugLine="txtLog.Text = txtLog.Text & From & \": \" & Msg & C";
__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .setText(__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .getText()+_from+": "+_msg+__c.CRLF);
RDebugUtils.currentLine=1835015;
 //BA.debugLineNum = 1835015;BA.debugLine="txtLog.SetSelection(txtLog.Text.Length, txtLog.Te";
__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .SetSelection(__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .getText().length(),__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .getText().length());
RDebugUtils.currentLine=1835016;
 //BA.debugLineNum = 1835016;BA.debugLine="End Sub";
return "";
}
public String  _astream_terminated(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "astream_terminated", false))
	 {return ((String) Debug.delegate(ba, "astream_terminated", null));}
RDebugUtils.currentLine=983040;
 //BA.debugLineNum = 983040;BA.debugLine="Sub AStream_Terminated";
RDebugUtils.currentLine=983041;
 //BA.debugLineNum = 983041;BA.debugLine="blnAppExitAstreamError = True";
__ref._blnappexitastreamerror /*boolean*/  = __c.True;
RDebugUtils.currentLine=983043;
 //BA.debugLineNum = 983043;BA.debugLine="If astream.IsInitialized Then";
if (__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=983044;
 //BA.debugLineNum = 983044;BA.debugLine="astream.Close";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Close();
RDebugUtils.currentLine=983045;
 //BA.debugLineNum = 983045;BA.debugLine="serial1.Close";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .Close();
 };
RDebugUtils.currentLine=983047;
 //BA.debugLineNum = 983047;BA.debugLine="EnableButtons";
__ref._enablebuttons /*String*/ (null);
RDebugUtils.currentLine=983048;
 //BA.debugLineNum = 983048;BA.debugLine="LogMessage(\"Status\", \"Connection is broken.\")";
__ref._logmessage /*String*/ (null,"Status","Connection is broken.");
RDebugUtils.currentLine=983049;
 //BA.debugLineNum = 983049;BA.debugLine="End Sub";
return "";
}
public String  _astream_newdata(b4j.example.b4xmainpage __ref,byte[] _buffer) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "astream_newdata", false))
	 {return ((String) Debug.delegate(ba, "astream_newdata", new Object[] {_buffer}));}
RDebugUtils.currentLine=720896;
 //BA.debugLineNum = 720896;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
RDebugUtils.currentLine=720898;
 //BA.debugLineNum = 720898;BA.debugLine="rxBufferString = rxBufferString & BytesToString(B";
__ref._rxbufferstring /*String*/  = __ref._rxbufferstring /*String*/ +__c.BytesToString(_buffer,(int) (0),_buffer.length,"UTF8");
RDebugUtils.currentLine=720901;
 //BA.debugLineNum = 720901;BA.debugLine="rxBuffer = AppendBytes(rxBuffer, Buffer)";
__ref._rxbuffer /*byte[]*/  = __ref._appendbytes /*byte[]*/ (null,__ref._rxbuffer /*byte[]*/ ,_buffer);
RDebugUtils.currentLine=720904;
 //BA.debugLineNum = 720904;BA.debugLine="If rxBufferString.Contains(\">\") Then";
if (__ref._rxbufferstring /*String*/ .contains(">")) { 
RDebugUtils.currentLine=720905;
 //BA.debugLineNum = 720905;BA.debugLine="HandleMessage(rxBufferString, rxBuffer)";
__ref._handlemessage /*void*/ (null,__ref._rxbufferstring /*String*/ ,__ref._rxbuffer /*byte[]*/ );
RDebugUtils.currentLine=720906;
 //BA.debugLineNum = 720906;BA.debugLine="rxBufferString = \"\"";
__ref._rxbufferstring /*String*/  = "";
RDebugUtils.currentLine=720907;
 //BA.debugLineNum = 720907;BA.debugLine="rxBuffer = Array As Byte() ' Resets to an empty";
__ref._rxbuffer /*byte[]*/  = new byte[]{};
 };
RDebugUtils.currentLine=720910;
 //BA.debugLineNum = 720910;BA.debugLine="End Sub";
return "";
}
public void  _handlemessage(b4j.example.b4xmainpage __ref,String _msg,byte[] _buffer) throws Exception{
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "handlemessage", false))
	 {Debug.delegate(ba, "handlemessage", new Object[] {_msg,_buffer}); return;}
ResumableSub_HandleMessage rsub = new ResumableSub_HandleMessage(this,__ref,_msg,_buffer);
rsub.resume(ba, null);
}
public static class ResumableSub_HandleMessage extends BA.ResumableSub {
public ResumableSub_HandleMessage(b4j.example.b4xmainpage parent,b4j.example.b4xmainpage __ref,String _msg,byte[] _buffer) {
this.parent = parent;
this.__ref = __ref;
this._msg = _msg;
this._buffer = _buffer;
this.__ref = parent;
}
b4j.example.b4xmainpage __ref;
b4j.example.b4xmainpage parent;
String _msg;
byte[] _buffer;
int _x = 0;
int step26;
int limit26;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xmainpage";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=851971;
 //BA.debugLineNum = 851971;BA.debugLine="If blnVerifyRequest = False Then";
if (true) break;

case 1:
//if
this.state = 4;
if (__ref._blnverifyrequest /*boolean*/ ==parent.__c.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=851972;
 //BA.debugLineNum = 851972;BA.debugLine="LogMessage(\"PIC16F88\", msg)";
__ref._logmessage /*String*/ (null,"PIC16F88",_msg);
 if (true) break;
;
RDebugUtils.currentLine=851975;
 //BA.debugLineNum = 851975;BA.debugLine="Select Case msg";

case 4:
//select
this.state = 31;
switch (BA.switchObjectToInt(_msg,"<InitReceived>","<ErrorTimeout>","<HandShakeTimeout>","<StartVerifyFlash>","<EndVerifyFlash>","<EndFlashErase>")) {
case 0: {
this.state = 6;
if (true) break;
}
case 1: {
this.state = 8;
if (true) break;
}
case 2: {
this.state = 10;
if (true) break;
}
case 3: {
this.state = 12;
if (true) break;
}
case 4: {
this.state = 14;
if (true) break;
}
case 5: {
this.state = 16;
if (true) break;
}
default: {
this.state = 18;
if (true) break;
}
}
if (true) break;

case 6:
//C
this.state = 31;
RDebugUtils.currentLine=851978;
 //BA.debugLineNum = 851978;BA.debugLine="bln16F88HandShakeSuccess = True";
__ref._bln16f88handshakesuccess /*boolean*/  = parent.__c.True;
RDebugUtils.currentLine=851979;
 //BA.debugLineNum = 851979;BA.debugLine="LogMessage(\"Status\", \"PIC responded! Done sendi";
__ref._logmessage /*String*/ (null,"Status","PIC responded! Done sending 0x55 0xAA");
 if (true) break;

case 8:
//C
this.state = 31;
RDebugUtils.currentLine=851983;
 //BA.debugLineNum = 851983;BA.debugLine="bln16F88ExitTimeoutError = True";
__ref._bln16f88exittimeouterror /*boolean*/  = parent.__c.True;
RDebugUtils.currentLine=851984;
 //BA.debugLineNum = 851984;BA.debugLine="EnableButtons";
__ref._enablebuttons /*String*/ (null);
RDebugUtils.currentLine=851985;
 //BA.debugLineNum = 851985;BA.debugLine="LogMessage(\"Status\", \"PIC reported timeout erro";
__ref._logmessage /*String*/ (null,"Status","PIC reported timeout error, try again");
 if (true) break;

case 10:
//C
this.state = 31;
RDebugUtils.currentLine=851989;
 //BA.debugLineNum = 851989;BA.debugLine="LogMessage(\"Status\", \"Timeout exiting bootloade";
__ref._logmessage /*String*/ (null,"Status","Timeout exiting bootloader --> entering application.");
 if (true) break;

case 12:
//C
this.state = 31;
RDebugUtils.currentLine=851993;
 //BA.debugLineNum = 851993;BA.debugLine="cntVerify = 0";
__ref._cntverify /*int*/  = (int) (0);
RDebugUtils.currentLine=851994;
 //BA.debugLineNum = 851994;BA.debugLine="blnVerifyRequest = True";
__ref._blnverifyrequest /*boolean*/  = parent.__c.True;
RDebugUtils.currentLine=851995;
 //BA.debugLineNum = 851995;BA.debugLine="LogMessage(\"Status\", \"Waiting for Verification.";
__ref._logmessage /*String*/ (null,"Status","Waiting for Verification...");
 if (true) break;

case 14:
//C
this.state = 31;
RDebugUtils.currentLine=851999;
 //BA.debugLineNum = 851999;BA.debugLine="EnableButtons";
__ref._enablebuttons /*String*/ (null);
RDebugUtils.currentLine=852000;
 //BA.debugLineNum = 852000;BA.debugLine="VerifyStatus";
__ref._verifystatus /*String*/ (null);
 if (true) break;

case 16:
//C
this.state = 31;
RDebugUtils.currentLine=852004;
 //BA.debugLineNum = 852004;BA.debugLine="Sleep(200)";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xmainpage", "handlemessage"),(int) (200));
this.state = 32;
return;
case 32:
//C
this.state = 31;
;
RDebugUtils.currentLine=852005;
 //BA.debugLineNum = 852005;BA.debugLine="SendFirmware";
__ref._sendfirmware /*void*/ (null);
 if (true) break;

case 18:
//C
this.state = 19;
RDebugUtils.currentLine=852009;
 //BA.debugLineNum = 852009;BA.debugLine="If blnVerifyRequest = True Then";
if (true) break;

case 19:
//if
this.state = 30;
if (__ref._blnverifyrequest /*boolean*/ ==parent.__c.True) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=852012;
 //BA.debugLineNum = 852012;BA.debugLine="For x = 0 To buffer.Length - 1 - 1	' last buff";
if (true) break;

case 22:
//for
this.state = 29;
step26 = 1;
limit26 = (int) (_buffer.length-1-1);
_x = (int) (0) ;
this.state = 33;
if (true) break;

case 33:
//C
this.state = 29;
if ((step26 > 0 && _x <= limit26) || (step26 < 0 && _x >= limit26)) this.state = 24;
if (true) break;

case 34:
//C
this.state = 33;
_x = ((int)(0 + _x + step26)) ;
if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=852014;
 //BA.debugLineNum = 852014;BA.debugLine="firmwareVerify(cntVerify) = buffer(x)";
__ref._firmwareverify /*byte[]*/ [__ref._cntverify /*int*/ ] = _buffer[_x];
RDebugUtils.currentLine=852017;
 //BA.debugLineNum = 852017;BA.debugLine="prgBar.Progress = Min(1, cntVerify / EXPECTED";
__ref._prgbar /*anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper*/ .setProgress(parent.__c.Min(1,__ref._cntverify /*int*/ /(double)__ref._expected_firmware_bytes /*int*/ ));
RDebugUtils.currentLine=852018;
 //BA.debugLineNum = 852018;BA.debugLine="cntVerify = cntVerify + 1";
__ref._cntverify /*int*/  = (int) (__ref._cntverify /*int*/ +1);
RDebugUtils.currentLine=852021;
 //BA.debugLineNum = 852021;BA.debugLine="If cntVerify >= EXPECTED_FIRMWARE_BYTES Then";
if (true) break;

case 25:
//if
this.state = 28;
if (__ref._cntverify /*int*/ >=__ref._expected_firmware_bytes /*int*/ ) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
RDebugUtils.currentLine=852024;
 //BA.debugLineNum = 852024;BA.debugLine="EnableButtons";
__ref._enablebuttons /*String*/ (null);
RDebugUtils.currentLine=852025;
 //BA.debugLineNum = 852025;BA.debugLine="Exit";
this.state = 29;
if (true) break;
 if (true) break;

case 28:
//C
this.state = 34;
;
 if (true) break;
if (true) break;

case 29:
//C
this.state = 30;
;
 if (true) break;

case 30:
//C
this.state = 31;
;
 if (true) break;

case 31:
//C
this.state = -1;
;
RDebugUtils.currentLine=852031;
 //BA.debugLineNum = 852031;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _enablebuttons(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "enablebuttons", false))
	 {return ((String) Debug.delegate(ba, "enablebuttons", null));}
RDebugUtils.currentLine=1769472;
 //BA.debugLineNum = 1769472;BA.debugLine="Sub EnableButtons";
RDebugUtils.currentLine=1769473;
 //BA.debugLineNum = 1769473;BA.debugLine="btnOpen.Enabled = True";
__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1769474;
 //BA.debugLineNum = 1769474;BA.debugLine="btnLoadFile.Enabled = True";
__ref._btnloadfile /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1769475;
 //BA.debugLineNum = 1769475;BA.debugLine="cmbPort.Enabled = True";
__ref._cmbport /*anywheresoftware.b4j.objects.ComboBoxWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1769476;
 //BA.debugLineNum = 1769476;BA.debugLine="blnVerifyRequest = False";
__ref._blnverifyrequest /*boolean*/  = __c.False;
RDebugUtils.currentLine=1769477;
 //BA.debugLineNum = 1769477;BA.debugLine="blnProgrammingInProgress = False";
__ref._blnprogramminginprogress /*boolean*/  = __c.False;
RDebugUtils.currentLine=1769478;
 //BA.debugLineNum = 1769478;BA.debugLine="btnFlash.Text = \"Flash\"";
__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setText("Flash");
RDebugUtils.currentLine=1769479;
 //BA.debugLineNum = 1769479;BA.debugLine="blnAppStopQuit = True";
__ref._blnappstopquit /*boolean*/  = __c.True;
RDebugUtils.currentLine=1769480;
 //BA.debugLineNum = 1769480;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = True";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).setResizable(__c.True);
RDebugUtils.currentLine=1769481;
 //BA.debugLineNum = 1769481;BA.debugLine="End Sub";
return "";
}
public anywheresoftware.b4a.keywords.Common.ResumableSubWrapper  _b4xpage_closerequest(b4j.example.b4xmainpage __ref) throws Exception{
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "b4xpage_closerequest", false))
	 {return ((anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) Debug.delegate(ba, "b4xpage_closerequest", null));}
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(this,__ref);
rsub.resume(ba, null);
return (anywheresoftware.b4a.keywords.Common.ResumableSubWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.keywords.Common.ResumableSubWrapper(), rsub);
}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(b4j.example.b4xmainpage parent,b4j.example.b4xmainpage __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4j.example.b4xmainpage __ref;
b4j.example.b4xmainpage parent;
Object _sf4 = null;
int _ret3 = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xmainpage";

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.ReturnFromResumableSub(this,null);return;}
case 0:
//C
this.state = 1;
RDebugUtils.currentLine=655363;
 //BA.debugLineNum = 655363;BA.debugLine="If blnProgrammingInProgress = True Then";
if (true) break;

case 1:
//if
this.state = 8;
if (__ref._blnprogramminginprogress /*boolean*/ ==parent.__c.True) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=655364;
 //BA.debugLineNum = 655364;BA.debugLine="Dim sf4 As Object = xui.Msgbox2Async(\"Flash in p";
_sf4 = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Msgbox2Async(ba,"Flash in progress!","Quit?","Yes","","No",(javafx.scene.image.Image)(parent.__c.Null));
RDebugUtils.currentLine=655365;
 //BA.debugLineNum = 655365;BA.debugLine="Wait For (sf4) Msgbox_Result(ret3 As Int)";
parent.__c.WaitFor("msgbox_result", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xmainpage", "b4xpage_closerequest"), _sf4);
this.state = 12;
return;
case 12:
//C
this.state = 4;
_ret3 = (int) result[1];
;
RDebugUtils.currentLine=655367;
 //BA.debugLineNum = 655367;BA.debugLine="If ret3 = xui.DialogResponse_Negative Then";
if (true) break;

case 4:
//if
this.state = 7;
if (_ret3==__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .DialogResponse_Negative) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=655368;
 //BA.debugLineNum = 655368;BA.debugLine="Return False  ' will not exit";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.False));return;};
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;
;
RDebugUtils.currentLine=655373;
 //BA.debugLineNum = 655373;BA.debugLine="If astream.IsInitialized Then";

case 8:
//if
this.state = 11;
if (__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=655374;
 //BA.debugLineNum = 655374;BA.debugLine="astream.Close";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Close();
RDebugUtils.currentLine=655375;
 //BA.debugLineNum = 655375;BA.debugLine="serial1.Close";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .Close();
 if (true) break;

case 11:
//C
this.state = -1;
;
RDebugUtils.currentLine=655378;
 //BA.debugLineNum = 655378;BA.debugLine="Return True";
if (true) {
parent.__c.ReturnFromResumableSub(this,(Object)(parent.__c.True));return;};
RDebugUtils.currentLine=655379;
 //BA.debugLineNum = 655379;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _b4xpage_created(b4j.example.b4xmainpage __ref,anywheresoftware.b4a.objects.B4XViewWrapper _root1) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "b4xpage_created", false))
	 {return ((String) Debug.delegate(ba, "b4xpage_created", new Object[] {_root1}));}
RDebugUtils.currentLine=589824;
 //BA.debugLineNum = 589824;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
RDebugUtils.currentLine=589825;
 //BA.debugLineNum = 589825;BA.debugLine="Root = Root1";
__ref._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/  = _root1;
RDebugUtils.currentLine=589826;
 //BA.debugLineNum = 589826;BA.debugLine="Root.LoadLayout(\"MainPage\")";
__ref._root /*anywheresoftware.b4a.objects.B4XViewWrapper*/ .LoadLayout("MainPage",ba);
RDebugUtils.currentLine=589827;
 //BA.debugLineNum = 589827;BA.debugLine="cmbPort.Items.AddAll(serial1.ListPorts)";
__ref._cmbport /*anywheresoftware.b4j.objects.ComboBoxWrapper*/ .getItems().AddAll(__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .ListPorts());
RDebugUtils.currentLine=589828;
 //BA.debugLineNum = 589828;BA.debugLine="B4XPages.SetTitle(Me, \"PIC16F88 Bootloader Upload";
_b4xpages._settitle /*String*/ (this,(Object)("PIC16F88 Bootloader Upload"));
RDebugUtils.currentLine=589829;
 //BA.debugLineNum = 589829;BA.debugLine="B4XPages.GetNativeParent(Me).WindowHeight = 700";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).setWindowHeight(700);
RDebugUtils.currentLine=589830;
 //BA.debugLineNum = 589830;BA.debugLine="B4XPages.GetNativeParent(Me).WindowWidth = 600";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).setWindowWidth(600);
RDebugUtils.currentLine=589831;
 //BA.debugLineNum = 589831;BA.debugLine="End Sub";
return "";
}
public void  _btnflash_click(b4j.example.b4xmainpage __ref) throws Exception{
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "btnflash_click", false))
	 {Debug.delegate(ba, "btnflash_click", null); return;}
ResumableSub_btnFlash_Click rsub = new ResumableSub_btnFlash_Click(this,__ref);
rsub.resume(ba, null);
}
public static class ResumableSub_btnFlash_Click extends BA.ResumableSub {
public ResumableSub_btnFlash_Click(b4j.example.b4xmainpage parent,b4j.example.b4xmainpage __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4j.example.b4xmainpage __ref;
b4j.example.b4xmainpage parent;
Object _sf6 = null;
int _ret3 = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xmainpage";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1376257;
 //BA.debugLineNum = 1376257;BA.debugLine="If btnOpen.Text = \"Open Port\" Then";
if (true) break;

case 1:
//if
this.state = 16;
if ((__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .getText()).equals("Open Port")) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 16;
RDebugUtils.currentLine=1376258;
 //BA.debugLineNum = 1376258;BA.debugLine="xui.Msgbox2Async(\"Please choose and open port!\",";
__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Msgbox2Async(ba,"Please choose and open port!","Port Closed","Ok","","",(javafx.scene.image.Image)(parent.__c.Null));
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=1376260;
 //BA.debugLineNum = 1376260;BA.debugLine="If btnFlash.Text = \"Flash\" Then";
if (true) break;

case 6:
//if
this.state = 15;
if ((__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .getText()).equals("Flash")) { 
this.state = 8;
}else {
this.state = 10;
}if (true) break;

case 8:
//C
this.state = 15;
RDebugUtils.currentLine=1376261;
 //BA.debugLineNum = 1376261;BA.debugLine="txtLog.Text = \"\"";
__ref._txtlog /*anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper*/ .setText("");
RDebugUtils.currentLine=1376262;
 //BA.debugLineNum = 1376262;BA.debugLine="btnFlash.Text = \"Stop\"";
__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setText("Stop");
RDebugUtils.currentLine=1376263;
 //BA.debugLineNum = 1376263;BA.debugLine="xui.Msgbox2Async(\"16F88 Application will restar";
__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Msgbox2Async(ba,"16F88 Application will restart to bootloader.  If not, then power off and on the PIC16F88.","Attention!","Ok","","",(javafx.scene.image.Image)(parent.__c.Null));
RDebugUtils.currentLine=1376264;
 //BA.debugLineNum = 1376264;BA.debugLine="SendHandshakeLoop";
__ref._sendhandshakeloop /*void*/ (null);
 if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=1376266;
 //BA.debugLineNum = 1376266;BA.debugLine="Dim sf6 As Object = xui.Msgbox2Async(\"Flash in";
_sf6 = __ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .Msgbox2Async(ba,"Flash in progress!","Stop?","Yes","","No",(javafx.scene.image.Image)(parent.__c.Null));
RDebugUtils.currentLine=1376267;
 //BA.debugLineNum = 1376267;BA.debugLine="Wait For (sf6) Msgbox_Result(ret3 As Int)";
parent.__c.WaitFor("msgbox_result", ba, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xmainpage", "btnflash_click"), _sf6);
this.state = 17;
return;
case 17:
//C
this.state = 11;
_ret3 = (int) result[1];
;
RDebugUtils.currentLine=1376269;
 //BA.debugLineNum = 1376269;BA.debugLine="If ret3 = xui.DialogResponse_Positive Then";
if (true) break;

case 11:
//if
this.state = 14;
if (_ret3==__ref._xui /*anywheresoftware.b4a.objects.B4XViewWrapper.XUI*/ .DialogResponse_Positive) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=1376270;
 //BA.debugLineNum = 1376270;BA.debugLine="LogMessage(\"Status\", \"User stop flash!\")";
__ref._logmessage /*String*/ (null,"Status","User stop flash!");
RDebugUtils.currentLine=1376271;
 //BA.debugLineNum = 1376271;BA.debugLine="EnableButtons";
__ref._enablebuttons /*String*/ (null);
 if (true) break;

case 14:
//C
this.state = 15;
;
 if (true) break;

case 15:
//C
this.state = 16;
;
 if (true) break;

case 16:
//C
this.state = -1;
;
RDebugUtils.currentLine=1376275;
 //BA.debugLineNum = 1376275;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public void  _sendhandshakeloop(b4j.example.b4xmainpage __ref) throws Exception{
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "sendhandshakeloop", false))
	 {Debug.delegate(ba, "sendhandshakeloop", null); return;}
ResumableSub_SendHandshakeLoop rsub = new ResumableSub_SendHandshakeLoop(this,__ref);
rsub.resume(ba, null);
}
public static class ResumableSub_SendHandshakeLoop extends BA.ResumableSub {
public ResumableSub_SendHandshakeLoop(b4j.example.b4xmainpage parent,b4j.example.b4xmainpage __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4j.example.b4xmainpage __ref;
b4j.example.b4xmainpage parent;
byte[] _b = null;
byte[] _b2 = null;
int _xtract = 0;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xmainpage";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1441794;
 //BA.debugLineNum = 1441794;BA.debugLine="If astream.IsInitialized = False Then";
if (true) break;

case 1:
//if
this.state = 4;
if (__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()==parent.__c.False) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1441795;
 //BA.debugLineNum = 1441795;BA.debugLine="LogMessage(\"Handshake\", \"Error Astream not initi";
__ref._logmessage /*String*/ (null,"Handshake","Error Astream not initialized");
RDebugUtils.currentLine=1441796;
 //BA.debugLineNum = 1441796;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
RDebugUtils.currentLine=1441799;
 //BA.debugLineNum = 1441799;BA.debugLine="Dim b() As Byte = Array As Byte(0x55)";
_b = new byte[]{(byte) (((int)0x55))};
RDebugUtils.currentLine=1441800;
 //BA.debugLineNum = 1441800;BA.debugLine="Dim b2() As Byte = Array As Byte(0xAA)";
_b2 = new byte[]{(byte) (((int)0xaa))};
RDebugUtils.currentLine=1441801;
 //BA.debugLineNum = 1441801;BA.debugLine="Dim xTract As Int = 0";
_xtract = (int) (0);
RDebugUtils.currentLine=1441803;
 //BA.debugLineNum = 1441803;BA.debugLine="DisableButtons";
__ref._disablebuttons /*String*/ (null);
RDebugUtils.currentLine=1441805;
 //BA.debugLineNum = 1441805;BA.debugLine="Do While True";
if (true) break;

case 5:
//do while
this.state = 32;
while (parent.__c.True) {
this.state = 7;
if (true) break;
}
if (true) break;

case 7:
//C
this.state = 8;
RDebugUtils.currentLine=1441807;
 //BA.debugLineNum = 1441807;BA.debugLine="If blnAppExitAstreamError = True Then";
if (true) break;

case 8:
//if
this.state = 11;
if (__ref._blnappexitastreamerror /*boolean*/ ==parent.__c.True) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
RDebugUtils.currentLine=1441808;
 //BA.debugLineNum = 1441808;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=1441812;
 //BA.debugLineNum = 1441812;BA.debugLine="If blnAppStopQuit = True Then";

case 11:
//if
this.state = 14;
if (__ref._blnappstopquit /*boolean*/ ==parent.__c.True) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
RDebugUtils.currentLine=1441813;
 //BA.debugLineNum = 1441813;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=1441817;
 //BA.debugLineNum = 1441817;BA.debugLine="If bln16F88HandShakeSuccess = True Then";

case 14:
//if
this.state = 25;
if (__ref._bln16f88handshakesuccess /*boolean*/ ==parent.__c.True) { 
this.state = 16;
}else {
this.state = 18;
}if (true) break;

case 16:
//C
this.state = 25;
RDebugUtils.currentLine=1441818;
 //BA.debugLineNum = 1441818;BA.debugLine="Return";
if (true) return ;
 if (true) break;

case 18:
//C
this.state = 19;
RDebugUtils.currentLine=1441820;
 //BA.debugLineNum = 1441820;BA.debugLine="If xTract = 0 Then";
if (true) break;

case 19:
//if
this.state = 24;
if (_xtract==0) { 
this.state = 21;
}else {
this.state = 23;
}if (true) break;

case 21:
//C
this.state = 24;
RDebugUtils.currentLine=1441821;
 //BA.debugLineNum = 1441821;BA.debugLine="astream.Write(b)";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_b);
RDebugUtils.currentLine=1441822;
 //BA.debugLineNum = 1441822;BA.debugLine="LogMessage(\"SendHandshakeLoop\", \"55\")";
__ref._logmessage /*String*/ (null,"SendHandshakeLoop","55");
 if (true) break;

case 23:
//C
this.state = 24;
RDebugUtils.currentLine=1441824;
 //BA.debugLineNum = 1441824;BA.debugLine="astream.Write(b2)";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_b2);
RDebugUtils.currentLine=1441825;
 //BA.debugLineNum = 1441825;BA.debugLine="LogMessage(\"SendHandshakeLoop\", \"AA\")";
__ref._logmessage /*String*/ (null,"SendHandshakeLoop","AA");
 if (true) break;

case 24:
//C
this.state = 25;
;
 if (true) break;

case 25:
//C
this.state = 26;
;
RDebugUtils.currentLine=1441830;
 //BA.debugLineNum = 1441830;BA.debugLine="Sleep(HANDSHAKE_DELAY_MS)";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xmainpage", "sendhandshakeloop"),__ref._handshake_delay_ms /*int*/ );
this.state = 33;
return;
case 33:
//C
this.state = 26;
;
RDebugUtils.currentLine=1441832;
 //BA.debugLineNum = 1441832;BA.debugLine="xTract = xTract + 1";
_xtract = (int) (_xtract+1);
RDebugUtils.currentLine=1441833;
 //BA.debugLineNum = 1441833;BA.debugLine="If xTract >= 2 Then xTract = 0";
if (true) break;

case 26:
//if
this.state = 31;
if (_xtract>=2) { 
this.state = 28;
;}if (true) break;

case 28:
//C
this.state = 31;
_xtract = (int) (0);
if (true) break;

case 31:
//C
this.state = 5;
;
 if (true) break;

case 32:
//C
this.state = -1;
;
RDebugUtils.currentLine=1441835;
 //BA.debugLineNum = 1441835;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _btnloadfile_click(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "btnloadfile_click", false))
	 {return ((String) Debug.delegate(ba, "btnloadfile_click", null));}
RDebugUtils.currentLine=1179648;
 //BA.debugLineNum = 1179648;BA.debugLine="Private Sub btnLoadFile_Click";
RDebugUtils.currentLine=1179649;
 //BA.debugLineNum = 1179649;BA.debugLine="firmware = Array As Byte() ' Resets to an empty a";
__ref._firmware /*byte[]*/  = new byte[]{};
RDebugUtils.currentLine=1179650;
 //BA.debugLineNum = 1179650;BA.debugLine="jframe.InitializeNewInstance(\"javax.swing.JFrame\"";
__ref._jframe /*anywheresoftware.b4j.object.JavaObject*/ .InitializeNewInstance("javax.swing.JFrame",new Object[]{(Object)("")});
RDebugUtils.currentLine=1179651;
 //BA.debugLineNum = 1179651;BA.debugLine="openFileDialog";
__ref._openfiledialog /*String*/ (null);
RDebugUtils.currentLine=1179652;
 //BA.debugLineNum = 1179652;BA.debugLine="End Sub";
return "";
}
public String  _openfiledialog(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "openfiledialog", false))
	 {return ((String) Debug.delegate(ba, "openfiledialog", null));}
anywheresoftware.b4j.object.JavaObject _filechooser = null;
int _result = 0;
anywheresoftware.b4j.object.JavaObject _selectedfile = null;
String _filepath = "";
String _filename = "";
RDebugUtils.currentLine=1245184;
 //BA.debugLineNum = 1245184;BA.debugLine="Private Sub openFileDialog";
RDebugUtils.currentLine=1245185;
 //BA.debugLineNum = 1245185;BA.debugLine="Dim fileChooser As JavaObject";
_filechooser = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=1245186;
 //BA.debugLineNum = 1245186;BA.debugLine="fileChooser.InitializeNewInstance(\"javax.swing.JF";
_filechooser.InitializeNewInstance("javax.swing.JFileChooser",new Object[]{__c.Null});
RDebugUtils.currentLine=1245187;
 //BA.debugLineNum = 1245187;BA.debugLine="Dim result As Int = fileChooser.RunMethod(\"showOp";
_result = (int)(BA.ObjectToNumber(_filechooser.RunMethod("showOpenDialog",new Object[]{(Object)(__ref._jframe /*anywheresoftware.b4j.object.JavaObject*/ .getObject())})));
RDebugUtils.currentLine=1245188;
 //BA.debugLineNum = 1245188;BA.debugLine="If result = fileChooser.GetField(\"APPROVE_OPTION\"";
if (_result==(double)(BA.ObjectToNumber(_filechooser.GetField("APPROVE_OPTION")))) { 
RDebugUtils.currentLine=1245189;
 //BA.debugLineNum = 1245189;BA.debugLine="Dim selectedFile As JavaObject = fileChooser.Run";
_selectedfile = new anywheresoftware.b4j.object.JavaObject();
_selectedfile = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_filechooser.RunMethod("getSelectedFile",(Object[])(__c.Null))));
RDebugUtils.currentLine=1245190;
 //BA.debugLineNum = 1245190;BA.debugLine="Dim filePath As String = selectedFile.RunMethod(";
_filepath = BA.ObjectToString(_selectedfile.RunMethod("getPath",(Object[])(__c.Null)));
RDebugUtils.currentLine=1245191;
 //BA.debugLineNum = 1245191;BA.debugLine="LogMessage(\"Status\", \"Selected file Path: \" & fi";
__ref._logmessage /*String*/ (null,"Status","Selected file Path: "+_filepath);
RDebugUtils.currentLine=1245192;
 //BA.debugLineNum = 1245192;BA.debugLine="Dim FileName As String = fileChooser.RunMethodJO";
_filename = BA.ObjectToString(_filechooser.RunMethodJO("getSelectedFile",(Object[])(__c.Null)).RunMethod("getName",(Object[])(__c.Null)));
RDebugUtils.currentLine=1245193;
 //BA.debugLineNum = 1245193;BA.debugLine="LogMessage(\"Status\", $\"Selected file name: ${Fil";
__ref._logmessage /*String*/ (null,"Status",("Selected file name: "+__c.SmartStringFormatter("",(Object)(_filename))+""));
RDebugUtils.currentLine=1245195;
 //BA.debugLineNum = 1245195;BA.debugLine="firmware = ConvertHexIntelToBinaryRange(filePath";
__ref._firmware /*byte[]*/  = __ref._converthexinteltobinaryrange /*byte[]*/ (null,_filepath,__ref._start_addr_flash /*int*/ );
 }else {
RDebugUtils.currentLine=1245197;
 //BA.debugLineNum = 1245197;BA.debugLine="LogMessage(\"Status\", \"No file selected.\")";
__ref._logmessage /*String*/ (null,"Status","No file selected.");
 };
RDebugUtils.currentLine=1245201;
 //BA.debugLineNum = 1245201;BA.debugLine="If jframe.IsInitialized Then";
if (__ref._jframe /*anywheresoftware.b4j.object.JavaObject*/ .IsInitialized()) { 
RDebugUtils.currentLine=1245202;
 //BA.debugLineNum = 1245202;BA.debugLine="jframe.RunMethod(\"dispose\", Null)";
__ref._jframe /*anywheresoftware.b4j.object.JavaObject*/ .RunMethod("dispose",(Object[])(__c.Null));
 };
RDebugUtils.currentLine=1245204;
 //BA.debugLineNum = 1245204;BA.debugLine="End Sub";
return "";
}
public String  _btnopen_click(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "btnopen_click", false))
	 {return ((String) Debug.delegate(ba, "btnopen_click", null));}
RDebugUtils.currentLine=1114112;
 //BA.debugLineNum = 1114112;BA.debugLine="Sub btnOpen_Click";
RDebugUtils.currentLine=1114115;
 //BA.debugLineNum = 1114115;BA.debugLine="If btnOpen.Text = \"Open Port\" Then";
if ((__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .getText()).equals("Open Port")) { 
RDebugUtils.currentLine=1114116;
 //BA.debugLineNum = 1114116;BA.debugLine="Try";
try {RDebugUtils.currentLine=1114117;
 //BA.debugLineNum = 1114117;BA.debugLine="serial1.Open(cmbPort.Value)";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .Open(BA.ObjectToString(__ref._cmbport /*anywheresoftware.b4j.objects.ComboBoxWrapper*/ .getValue()));
RDebugUtils.currentLine=1114118;
 //BA.debugLineNum = 1114118;BA.debugLine="serial1.SetParams(serial1.BAUDRATE_57600, seria";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .SetParams(__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .BAUDRATE_57600,__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .DATABITS_8,__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .STOPBITS_1,__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .PARITY_NONE);
RDebugUtils.currentLine=1114119;
 //BA.debugLineNum = 1114119;BA.debugLine="astream.Initialize(serial1.GetInputStream, seri";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Initialize(ba,__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .GetInputStream(),__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .GetOutputStream(),"astream");
 } 
       catch (Exception e7) {
			ba.setLastException(e7);RDebugUtils.currentLine=1114121;
 //BA.debugLineNum = 1114121;BA.debugLine="LogMessage(\"Status\", \"Error Open Port\" & LastEx";
__ref._logmessage /*String*/ (null,"Status","Error Open Port"+BA.ObjectToString(__c.LastException(ba)));
RDebugUtils.currentLine=1114122;
 //BA.debugLineNum = 1114122;BA.debugLine="Return";
if (true) return "";
 };
RDebugUtils.currentLine=1114124;
 //BA.debugLineNum = 1114124;BA.debugLine="btnOpen.Text = \"Close Port\"";
__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setText("Close Port");
RDebugUtils.currentLine=1114125;
 //BA.debugLineNum = 1114125;BA.debugLine="LogMessage(\"Status\", \"Port Opened\")";
__ref._logmessage /*String*/ (null,"Status","Port Opened");
 }else {
RDebugUtils.currentLine=1114129;
 //BA.debugLineNum = 1114129;BA.debugLine="If astream.IsInitialized Then";
if (__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .IsInitialized()) { 
RDebugUtils.currentLine=1114130;
 //BA.debugLineNum = 1114130;BA.debugLine="astream.Close";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Close();
RDebugUtils.currentLine=1114131;
 //BA.debugLineNum = 1114131;BA.debugLine="serial1.Close";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .Close();
 };
RDebugUtils.currentLine=1114133;
 //BA.debugLineNum = 1114133;BA.debugLine="btnOpen.Text = \"Open Port\"";
__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setText("Open Port");
RDebugUtils.currentLine=1114134;
 //BA.debugLineNum = 1114134;BA.debugLine="LogMessage(\"Status\", \"Port Closed\")";
__ref._logmessage /*String*/ (null,"Status","Port Closed");
 };
RDebugUtils.currentLine=1114136;
 //BA.debugLineNum = 1114136;BA.debugLine="End Sub";
return "";
}
public String  _bytestohexstring(b4j.example.b4xmainpage __ref,byte[] _b) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "bytestohexstring", false))
	 {return ((String) Debug.delegate(ba, "bytestohexstring", new Object[] {_b}));}
anywheresoftware.b4a.keywords.StringBuilderWrapper _sb = null;
byte _bt = (byte)0;
String _bytestring = "";
RDebugUtils.currentLine=1900544;
 //BA.debugLineNum = 1900544;BA.debugLine="Sub BytesToHexString(b() As Byte) As String";
RDebugUtils.currentLine=1900545;
 //BA.debugLineNum = 1900545;BA.debugLine="Dim sb As StringBuilder";
_sb = new anywheresoftware.b4a.keywords.StringBuilderWrapper();
RDebugUtils.currentLine=1900546;
 //BA.debugLineNum = 1900546;BA.debugLine="sb.Initialize";
_sb.Initialize();
RDebugUtils.currentLine=1900547;
 //BA.debugLineNum = 1900547;BA.debugLine="For Each bt As Byte In b";
{
final byte[] group3 = _b;
final int groupLen3 = group3.length
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_bt = group3[index3];
RDebugUtils.currentLine=1900548;
 //BA.debugLineNum = 1900548;BA.debugLine="Dim byteString As String";
_bytestring = "";
RDebugUtils.currentLine=1900549;
 //BA.debugLineNum = 1900549;BA.debugLine="byteString = Bit.ToHexString(Bit.And(bt, 0xFF))";
_bytestring = __c.Bit.ToHexString(__c.Bit.And((int) (_bt),((int)0xff)));
RDebugUtils.currentLine=1900550;
 //BA.debugLineNum = 1900550;BA.debugLine="If byteString.Length = 1 Then byteString = \"0\" &";
if (_bytestring.length()==1) { 
_bytestring = "0"+_bytestring;};
RDebugUtils.currentLine=1900551;
 //BA.debugLineNum = 1900551;BA.debugLine="sb.Append(byteString).Append(\" \")";
_sb.Append(_bytestring).Append(" ");
 }
};
RDebugUtils.currentLine=1900553;
 //BA.debugLineNum = 1900553;BA.debugLine="Return sb.ToString.Trim.ToUpperCase";
if (true) return _sb.ToString().trim().toUpperCase();
RDebugUtils.currentLine=1900554;
 //BA.debugLineNum = 1900554;BA.debugLine="End Sub";
return "";
}
public String  _bytestohexstring2(b4j.example.b4xmainpage __ref,byte _b) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "bytestohexstring2", false))
	 {return ((String) Debug.delegate(ba, "bytestohexstring2", new Object[] {_b}));}
String _bytestring = "";
RDebugUtils.currentLine=1966080;
 //BA.debugLineNum = 1966080;BA.debugLine="Sub BytesToHexString2(b As Byte) As String";
RDebugUtils.currentLine=1966081;
 //BA.debugLineNum = 1966081;BA.debugLine="Dim byteString As String";
_bytestring = "";
RDebugUtils.currentLine=1966083;
 //BA.debugLineNum = 1966083;BA.debugLine="byteString = Bit.ToHexString(Bit.And(b, 0xFF))";
_bytestring = __c.Bit.ToHexString(__c.Bit.And((int) (_b),((int)0xff)));
RDebugUtils.currentLine=1966084;
 //BA.debugLineNum = 1966084;BA.debugLine="If byteString.Length = 1 Then byteString = \"0\" &";
if (_bytestring.length()==1) { 
_bytestring = "0"+_bytestring;};
RDebugUtils.currentLine=1966086;
 //BA.debugLineNum = 1966086;BA.debugLine="Return byteString.ToUpperCase";
if (true) return _bytestring.toUpperCase();
RDebugUtils.currentLine=1966087;
 //BA.debugLineNum = 1966087;BA.debugLine="End Sub";
return "";
}
public String  _class_globals(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
RDebugUtils.currentLine=458752;
 //BA.debugLineNum = 458752;BA.debugLine="Sub Class_Globals";
RDebugUtils.currentLine=458753;
 //BA.debugLineNum = 458753;BA.debugLine="Private Const START_ADDR_FLASH As Int = 0x0600";
_start_addr_flash = ((int)0x0600);
RDebugUtils.currentLine=458754;
 //BA.debugLineNum = 458754;BA.debugLine="Private Const END_ADDR_FLASH As Int = 0x0FFF			'";
_end_addr_flash = ((int)0x0fff);
RDebugUtils.currentLine=458755;
 //BA.debugLineNum = 458755;BA.debugLine="Private Const WORDS_PER_PACKET As Int = 4				' To";
_words_per_packet = (int) (4);
RDebugUtils.currentLine=458756;
 //BA.debugLineNum = 458756;BA.debugLine="Private Const BLOCK_SIZE As Int = WORDS_PER_PACKE";
_block_size = (int) (__ref._words_per_packet /*int*/ *2);
RDebugUtils.currentLine=458757;
 //BA.debugLineNum = 458757;BA.debugLine="Private Const PACKET_DELAY_MS As Int = 2				' Wri";
_packet_delay_ms = (int) (2);
RDebugUtils.currentLine=458758;
 //BA.debugLineNum = 458758;BA.debugLine="Private Const HANDSHAKE_DELAY_MS As Int = 200";
_handshake_delay_ms = (int) (200);
RDebugUtils.currentLine=458759;
 //BA.debugLineNum = 458759;BA.debugLine="Private Const MSB_WORD_ADDR As Int = 0x3F				' 14";
_msb_word_addr = ((int)0x3f);
RDebugUtils.currentLine=458760;
 //BA.debugLineNum = 458760;BA.debugLine="Private Const EXPECTED_FIRMWARE_BYTES As Int = (E";
_expected_firmware_bytes = (int) ((__ref._end_addr_flash /*int*/ -__ref._start_addr_flash /*int*/ +1)*2);
RDebugUtils.currentLine=458762;
 //BA.debugLineNum = 458762;BA.debugLine="Private serial1 As Serial								' UART COM";
_serial1 = new anywheresoftware.b4j.serial.Serial();
RDebugUtils.currentLine=458763;
 //BA.debugLineNum = 458763;BA.debugLine="Private astream As AsyncStreams";
_astream = new anywheresoftware.b4a.randomaccessfile.AsyncStreams();
RDebugUtils.currentLine=458764;
 //BA.debugLineNum = 458764;BA.debugLine="Private jframe As JavaObject							' For file ope";
_jframe = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=458766;
 //BA.debugLineNum = 458766;BA.debugLine="Private Root As B4XView";
_root = new anywheresoftware.b4a.objects.B4XViewWrapper();
RDebugUtils.currentLine=458767;
 //BA.debugLineNum = 458767;BA.debugLine="Private xui As XUI";
_xui = new anywheresoftware.b4a.objects.B4XViewWrapper.XUI();
RDebugUtils.currentLine=458769;
 //BA.debugLineNum = 458769;BA.debugLine="Private btnFlash As Button";
_btnflash = new anywheresoftware.b4j.objects.ButtonWrapper();
RDebugUtils.currentLine=458770;
 //BA.debugLineNum = 458770;BA.debugLine="Private btnLoadFile As Button";
_btnloadfile = new anywheresoftware.b4j.objects.ButtonWrapper();
RDebugUtils.currentLine=458771;
 //BA.debugLineNum = 458771;BA.debugLine="Private btnOpen As Button";
_btnopen = new anywheresoftware.b4j.objects.ButtonWrapper();
RDebugUtils.currentLine=458772;
 //BA.debugLineNum = 458772;BA.debugLine="Private txtLog As TextArea";
_txtlog = new anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper();
RDebugUtils.currentLine=458773;
 //BA.debugLineNum = 458773;BA.debugLine="Private cmbPort As ComboBox";
_cmbport = new anywheresoftware.b4j.objects.ComboBoxWrapper();
RDebugUtils.currentLine=458774;
 //BA.debugLineNum = 458774;BA.debugLine="Private prgBar As ProgressBar";
_prgbar = new anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper();
RDebugUtils.currentLine=458777;
 //BA.debugLineNum = 458777;BA.debugLine="Private firmware() As Byte								' firmware bina";
_firmware = new byte[(int) (0)];
;
RDebugUtils.currentLine=458778;
 //BA.debugLineNum = 458778;BA.debugLine="Private firmwareVerify(EXPECTED_FIRMWARE_BYTES) A";
_firmwareverify = new byte[__ref._expected_firmware_bytes /*int*/ ];
;
RDebugUtils.currentLine=458779;
 //BA.debugLineNum = 458779;BA.debugLine="Private cntVerify As Int								' Counter to dete";
_cntverify = 0;
RDebugUtils.currentLine=458780;
 //BA.debugLineNum = 458780;BA.debugLine="Private blnVerifyRequest As Boolean						' Reques";
_blnverifyrequest = false;
RDebugUtils.currentLine=458781;
 //BA.debugLineNum = 458781;BA.debugLine="Private blnProgrammingInProgress As Boolean				'";
_blnprogramminginprogress = false;
RDebugUtils.currentLine=458782;
 //BA.debugLineNum = 458782;BA.debugLine="Private bln16F88HandShakeSuccess As Boolean				'";
_bln16f88handshakesuccess = false;
RDebugUtils.currentLine=458783;
 //BA.debugLineNum = 458783;BA.debugLine="Private bln16F88ExitTimeoutError As Boolean				'";
_bln16f88exittimeouterror = false;
RDebugUtils.currentLine=458784;
 //BA.debugLineNum = 458784;BA.debugLine="Private blnAppExitAstreamError	As Boolean				' As";
_blnappexitastreamerror = false;
RDebugUtils.currentLine=458785;
 //BA.debugLineNum = 458785;BA.debugLine="Private blnAppStopQuit As Boolean						' Exit loo";
_blnappstopquit = false;
RDebugUtils.currentLine=458787;
 //BA.debugLineNum = 458787;BA.debugLine="Private rxBufferString As String						' Buffer Ne";
_rxbufferstring = "";
RDebugUtils.currentLine=458788;
 //BA.debugLineNum = 458788;BA.debugLine="Private rxBuffer() As Byte								' Buffer Newdat";
_rxbuffer = new byte[(int) (0)];
;
RDebugUtils.currentLine=458791;
 //BA.debugLineNum = 458791;BA.debugLine="End Sub";
return "";
}
public String  _cmbport_selectedindexchanged(b4j.example.b4xmainpage __ref,int _index,Object _value) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "cmbport_selectedindexchanged", false))
	 {return ((String) Debug.delegate(ba, "cmbport_selectedindexchanged", new Object[] {_index,_value}));}
RDebugUtils.currentLine=1048576;
 //BA.debugLineNum = 1048576;BA.debugLine="Sub cmbPort_SelectedIndexChanged(Index As Int, Val";
RDebugUtils.currentLine=1048577;
 //BA.debugLineNum = 1048577;BA.debugLine="btnOpen.Enabled = Index > -1 'enable the button i";
__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(_index>-1);
RDebugUtils.currentLine=1048578;
 //BA.debugLineNum = 1048578;BA.debugLine="End Sub";
return "";
}
public byte[]  _converthexinteltobinaryrange(b4j.example.b4xmainpage __ref,String _filepath,int _startaddr) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "converthexinteltobinaryrange", false))
	 {return ((byte[]) Debug.delegate(ba, "converthexinteltobinaryrange", new Object[] {_filepath,_startaddr}));}
anywheresoftware.b4a.objects.collections.List _lines = null;
int _startbyte = 0;
byte[] _firmwaredata = null;
int _i = 0;
boolean _blndetectrecordavailable = false;
String _line = "";
int _bytecount = 0;
int _wordaddr = 0;
int _recordtype = 0;
int _byteaddr = 0;
int _b = 0;
int _arrayindex = 0;
RDebugUtils.currentLine=1310720;
 //BA.debugLineNum = 1310720;BA.debugLine="Sub ConvertHexIntelToBinaryRange(filepath As Strin";
RDebugUtils.currentLine=1310721;
 //BA.debugLineNum = 1310721;BA.debugLine="Dim lines As List = File.ReadList(\"\", filepath)";
_lines = new anywheresoftware.b4a.objects.collections.List();
_lines = __c.File.ReadList("",_filepath);
RDebugUtils.currentLine=1310724;
 //BA.debugLineNum = 1310724;BA.debugLine="Dim startByte As Int = startAddr * 2";
_startbyte = (int) (_startaddr*2);
RDebugUtils.currentLine=1310727;
 //BA.debugLineNum = 1310727;BA.debugLine="Dim firmwareData(EXPECTED_FIRMWARE_BYTES) As Byte";
_firmwaredata = new byte[__ref._expected_firmware_bytes /*int*/ ];
;
RDebugUtils.currentLine=1310730;
 //BA.debugLineNum = 1310730;BA.debugLine="For i = 0 To firmwareData.Length - 1 Step 2";
{
final int step4 = 2;
final int limit4 = (int) (_firmwaredata.length-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1310731;
 //BA.debugLineNum = 1310731;BA.debugLine="firmwareData(i) = 0xFF";
_firmwaredata[_i] = (byte) (((int)0xff));
RDebugUtils.currentLine=1310732;
 //BA.debugLineNum = 1310732;BA.debugLine="firmwareData(i+1) = MSB_WORD_ADDR			' 0x3F on PI";
_firmwaredata[(int) (_i+1)] = (byte) (__ref._msb_word_addr /*int*/ );
 }
};
RDebugUtils.currentLine=1310736;
 //BA.debugLineNum = 1310736;BA.debugLine="Dim blnDetectRecordAvailable As Boolean = False";
_blndetectrecordavailable = __c.False;
RDebugUtils.currentLine=1310739;
 //BA.debugLineNum = 1310739;BA.debugLine="For Each line As String In lines";
{
final anywheresoftware.b4a.BA.IterableList group9 = _lines;
final int groupLen9 = group9.getSize()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_line = BA.ObjectToString(group9.Get(index9));
RDebugUtils.currentLine=1310740;
 //BA.debugLineNum = 1310740;BA.debugLine="If line.Length = 0 Or line.CharAt(0) <> \":\" Then";
if (_line.length()==0 || _line.charAt((int) (0))!=BA.ObjectToChar(":")) { 
if (true) continue;};
RDebugUtils.currentLine=1310742;
 //BA.debugLineNum = 1310742;BA.debugLine="Dim byteCount As Int = Bit.ParseInt(line.SubStri";
_bytecount = __c.Bit.ParseInt(_line.substring((int) (1),(int) (3)),(int) (16));
RDebugUtils.currentLine=1310743;
 //BA.debugLineNum = 1310743;BA.debugLine="Dim wordAddr As Int = Bit.ParseInt(line.SubStrin";
_wordaddr = __c.Bit.ParseInt(_line.substring((int) (3),(int) (7)),(int) (16));
RDebugUtils.currentLine=1310744;
 //BA.debugLineNum = 1310744;BA.debugLine="Dim recordType As Int = Bit.ParseInt(line.SubStr";
_recordtype = __c.Bit.ParseInt(_line.substring((int) (7),(int) (9)),(int) (16));
RDebugUtils.currentLine=1310747;
 //BA.debugLineNum = 1310747;BA.debugLine="If recordType <> 0 Then Continue";
if (_recordtype!=0) { 
if (true) continue;};
RDebugUtils.currentLine=1310749;
 //BA.debugLineNum = 1310749;BA.debugLine="Dim byteAddr As Int = wordAddr";
_byteaddr = _wordaddr;
RDebugUtils.currentLine=1310751;
 //BA.debugLineNum = 1310751;BA.debugLine="For i = 0 To byteCount - 1";
{
final int step16 = 1;
final int limit16 = (int) (_bytecount-1);
_i = (int) (0) ;
for (;_i <= limit16 ;_i = _i + step16 ) {
RDebugUtils.currentLine=1310752;
 //BA.debugLineNum = 1310752;BA.debugLine="Dim b As Int = Bit.ParseInt(line.SubString2(9 +";
_b = __c.Bit.ParseInt(_line.substring((int) (9+_i*2),(int) (11+_i*2)),(int) (16));
RDebugUtils.currentLine=1310753;
 //BA.debugLineNum = 1310753;BA.debugLine="Dim arrayIndex As Int = byteAddr - startByte +";
_arrayindex = (int) (_byteaddr-_startbyte+_i);
RDebugUtils.currentLine=1310756;
 //BA.debugLineNum = 1310756;BA.debugLine="If arrayIndex >= 0 And arrayIndex < firmwareDat";
if (_arrayindex>=0 && _arrayindex<_firmwaredata.length) { 
RDebugUtils.currentLine=1310757;
 //BA.debugLineNum = 1310757;BA.debugLine="firmwareData(arrayIndex) = b";
_firmwaredata[_arrayindex] = (byte) (_b);
RDebugUtils.currentLine=1310758;
 //BA.debugLineNum = 1310758;BA.debugLine="blnDetectRecordAvailable = True";
_blndetectrecordavailable = __c.True;
 };
 }
};
 }
};
RDebugUtils.currentLine=1310765;
 //BA.debugLineNum = 1310765;BA.debugLine="If blnDetectRecordAvailable Then";
if (_blndetectrecordavailable) { 
RDebugUtils.currentLine=1310766;
 //BA.debugLineNum = 1310766;BA.debugLine="btnFlash.Enabled = True";
__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.True);
RDebugUtils.currentLine=1310767;
 //BA.debugLineNum = 1310767;BA.debugLine="LogMessage(\"Status\", \"Firmware bytes: \" & firmwa";
__ref._logmessage /*String*/ (null,"Status","Firmware bytes: "+BA.NumberToString(_firmwaredata.length));
 }else {
RDebugUtils.currentLine=1310769;
 //BA.debugLineNum = 1310769;BA.debugLine="btnFlash.Enabled = False";
__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1310770;
 //BA.debugLineNum = 1310770;BA.debugLine="LogMessage(\"Status\", \"Conversion did not detect";
__ref._logmessage /*String*/ (null,"Status","Conversion did not detect valid Intel HEX Record");
 };
RDebugUtils.currentLine=1310773;
 //BA.debugLineNum = 1310773;BA.debugLine="Return firmwareData";
if (true) return _firmwaredata;
RDebugUtils.currentLine=1310774;
 //BA.debugLineNum = 1310774;BA.debugLine="End Sub";
return null;
}
public String  _disablebuttons(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "disablebuttons", false))
	 {return ((String) Debug.delegate(ba, "disablebuttons", null));}
RDebugUtils.currentLine=1703936;
 //BA.debugLineNum = 1703936;BA.debugLine="Sub DisableButtons";
RDebugUtils.currentLine=1703937;
 //BA.debugLineNum = 1703937;BA.debugLine="btnOpen.Enabled = False";
__ref._btnopen /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1703938;
 //BA.debugLineNum = 1703938;BA.debugLine="btnLoadFile.Enabled = False";
__ref._btnloadfile /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1703939;
 //BA.debugLineNum = 1703939;BA.debugLine="cmbPort.Enabled = False";
__ref._cmbport /*anywheresoftware.b4j.objects.ComboBoxWrapper*/ .setEnabled(__c.False);
RDebugUtils.currentLine=1703940;
 //BA.debugLineNum = 1703940;BA.debugLine="cntVerify = 0";
__ref._cntverify /*int*/  = (int) (0);
RDebugUtils.currentLine=1703941;
 //BA.debugLineNum = 1703941;BA.debugLine="blnProgrammingInProgress = True";
__ref._blnprogramminginprogress /*boolean*/  = __c.True;
RDebugUtils.currentLine=1703942;
 //BA.debugLineNum = 1703942;BA.debugLine="btnFlash.Text = \"Stop\"";
__ref._btnflash /*anywheresoftware.b4j.objects.ButtonWrapper*/ .setText("Stop");
RDebugUtils.currentLine=1703943;
 //BA.debugLineNum = 1703943;BA.debugLine="blnAppStopQuit = False";
__ref._blnappstopquit /*boolean*/  = __c.False;
RDebugUtils.currentLine=1703944;
 //BA.debugLineNum = 1703944;BA.debugLine="bln16F88HandShakeSuccess = False";
__ref._bln16f88handshakesuccess /*boolean*/  = __c.False;
RDebugUtils.currentLine=1703945;
 //BA.debugLineNum = 1703945;BA.debugLine="bln16F88ExitTimeoutError = False";
__ref._bln16f88exittimeouterror /*boolean*/  = __c.False;
RDebugUtils.currentLine=1703946;
 //BA.debugLineNum = 1703946;BA.debugLine="blnAppExitAstreamError = False";
__ref._blnappexitastreamerror /*boolean*/  = __c.False;
RDebugUtils.currentLine=1703947;
 //BA.debugLineNum = 1703947;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = False";
_b4xpages._getnativeparent /*anywheresoftware.b4j.objects.Form*/ (this).setResizable(__c.False);
RDebugUtils.currentLine=1703948;
 //BA.debugLineNum = 1703948;BA.debugLine="End Sub";
return "";
}
public String  _verifystatus(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "verifystatus", false))
	 {return ((String) Debug.delegate(ba, "verifystatus", null));}
RDebugUtils.currentLine=1572864;
 //BA.debugLineNum = 1572864;BA.debugLine="Sub VerifyStatus";
RDebugUtils.currentLine=1572865;
 //BA.debugLineNum = 1572865;BA.debugLine="If VerifyFirmware = True Then";
if (__ref._verifyfirmware /*boolean*/ (null)==__c.True) { 
RDebugUtils.currentLine=1572866;
 //BA.debugLineNum = 1572866;BA.debugLine="LogMessage(\"Status\", \"Programming/Verify Success";
__ref._logmessage /*String*/ (null,"Status","Programming/Verify Success");
 }else {
RDebugUtils.currentLine=1572868;
 //BA.debugLineNum = 1572868;BA.debugLine="LogMessage(\"Status\", \"Programming/Verify Failed!";
__ref._logmessage /*String*/ (null,"Status","Programming/Verify Failed!");
 };
RDebugUtils.currentLine=1572870;
 //BA.debugLineNum = 1572870;BA.debugLine="End Sub";
return "";
}
public void  _sendfirmware(b4j.example.b4xmainpage __ref) throws Exception{
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "sendfirmware", false))
	 {Debug.delegate(ba, "sendfirmware", null); return;}
ResumableSub_SendFirmware rsub = new ResumableSub_SendFirmware(this,__ref);
rsub.resume(ba, null);
}
public static class ResumableSub_SendFirmware extends BA.ResumableSub {
public ResumableSub_SendFirmware(b4j.example.b4xmainpage parent,b4j.example.b4xmainpage __ref) {
this.parent = parent;
this.__ref = __ref;
this.__ref = parent;
}
b4j.example.b4xmainpage __ref;
b4j.example.b4xmainpage parent;
int _totalblocks = 0;
byte[] _block = null;
int _i = 0;
int _remaining = 0;
int _currentblocksize = 0;
int _j = 0;
int _x = 0;
byte[] _b = null;
int step4;
int limit4;
int step7;
int limit7;
int step23;
int limit23;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="b4xmainpage";

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=1507331;
 //BA.debugLineNum = 1507331;BA.debugLine="Dim totalBlocks As Int = Ceil(firmware.Length / B";
_totalblocks = (int) (parent.__c.Ceil(__ref._firmware /*byte[]*/ .length/(double)__ref._block_size /*int*/ ));
RDebugUtils.currentLine=1507332;
 //BA.debugLineNum = 1507332;BA.debugLine="Dim block(BLOCK_SIZE) As Byte";
_block = new byte[__ref._block_size /*int*/ ];
;
RDebugUtils.currentLine=1507334;
 //BA.debugLineNum = 1507334;BA.debugLine="LogMessage(\"FirmwareUpload\", \"Firmware size: \" &";
__ref._logmessage /*String*/ (null,"FirmwareUpload","Firmware size: "+BA.NumberToString(__ref._firmware /*byte[]*/ .length)+" bytes, total blocks: "+BA.NumberToString(_totalblocks));
RDebugUtils.currentLine=1507336;
 //BA.debugLineNum = 1507336;BA.debugLine="For i = 0 To firmware.Length - 1 Step BLOCK_SIZE";
if (true) break;

case 1:
//for
this.state = 26;
step4 = __ref._block_size /*int*/ ;
limit4 = (int) (__ref._firmware /*byte[]*/ .length-1);
_i = (int) (0) ;
this.state = 27;
if (true) break;

case 27:
//C
this.state = 26;
if ((step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4)) this.state = 3;
if (true) break;

case 28:
//C
this.state = 27;
_i = ((int)(0 + _i + step4)) ;
if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=1507339;
 //BA.debugLineNum = 1507339;BA.debugLine="Dim remaining As Int = firmware.Length - i";
_remaining = (int) (__ref._firmware /*byte[]*/ .length-_i);
RDebugUtils.currentLine=1507340;
 //BA.debugLineNum = 1507340;BA.debugLine="Dim currentBlockSize As Int = Min(BLOCK_SIZE, re";
_currentblocksize = (int) (parent.__c.Min(__ref._block_size /*int*/ ,_remaining));
RDebugUtils.currentLine=1507342;
 //BA.debugLineNum = 1507342;BA.debugLine="For j = 0 To BLOCK_SIZE - 1";
if (true) break;

case 4:
//for
this.state = 13;
step7 = 1;
limit7 = (int) (__ref._block_size /*int*/ -1);
_j = (int) (0) ;
this.state = 29;
if (true) break;

case 29:
//C
this.state = 13;
if ((step7 > 0 && _j <= limit7) || (step7 < 0 && _j >= limit7)) this.state = 6;
if (true) break;

case 30:
//C
this.state = 29;
_j = ((int)(0 + _j + step7)) ;
if (true) break;

case 6:
//C
this.state = 7;
RDebugUtils.currentLine=1507343;
 //BA.debugLineNum = 1507343;BA.debugLine="If j < currentBlockSize Then";
if (true) break;

case 7:
//if
this.state = 12;
if (_j<_currentblocksize) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
RDebugUtils.currentLine=1507345;
 //BA.debugLineNum = 1507345;BA.debugLine="block(j) = firmware(i + j)";
_block[_j] = __ref._firmware /*byte[]*/ [(int) (_i+_j)];
 if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=1507348;
 //BA.debugLineNum = 1507348;BA.debugLine="block(j) = 0xFF	' Pic 16F88 MSB is 0x3F but 0x";
_block[_j] = (byte) (((int)0xff));
 if (true) break;

case 12:
//C
this.state = 30;
;
 if (true) break;
if (true) break;
;
RDebugUtils.currentLine=1507353;
 //BA.debugLineNum = 1507353;BA.debugLine="If bln16F88ExitTimeoutError = True Then";

case 13:
//if
this.state = 16;
if (__ref._bln16f88exittimeouterror /*boolean*/ ==parent.__c.True) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
RDebugUtils.currentLine=1507354;
 //BA.debugLineNum = 1507354;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=1507358;
 //BA.debugLineNum = 1507358;BA.debugLine="If blnAppExitAstreamError = True Then";

case 16:
//if
this.state = 19;
if (__ref._blnappexitastreamerror /*boolean*/ ==parent.__c.True) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
RDebugUtils.currentLine=1507359;
 //BA.debugLineNum = 1507359;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=1507363;
 //BA.debugLineNum = 1507363;BA.debugLine="If blnAppStopQuit = True Then";

case 19:
//if
this.state = 22;
if (__ref._blnappstopquit /*boolean*/ ==parent.__c.True) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=1507364;
 //BA.debugLineNum = 1507364;BA.debugLine="Return";
if (true) return ;
 if (true) break;
;
RDebugUtils.currentLine=1507368;
 //BA.debugLineNum = 1507368;BA.debugLine="For x = 0 To BLOCK_SIZE - 1";

case 22:
//for
this.state = 25;
step23 = 1;
limit23 = (int) (__ref._block_size /*int*/ -1);
_x = (int) (0) ;
this.state = 31;
if (true) break;

case 31:
//C
this.state = 25;
if ((step23 > 0 && _x <= limit23) || (step23 < 0 && _x >= limit23)) this.state = 24;
if (true) break;

case 32:
//C
this.state = 31;
_x = ((int)(0 + _x + step23)) ;
if (true) break;

case 24:
//C
this.state = 32;
RDebugUtils.currentLine=1507369;
 //BA.debugLineNum = 1507369;BA.debugLine="Dim b(1) As Byte       				' single-byte array";
_b = new byte[(int) (1)];
;
RDebugUtils.currentLine=1507370;
 //BA.debugLineNum = 1507370;BA.debugLine="b(0) = block(x)        				' copy current byte";
_b[(int) (0)] = _block[_x];
RDebugUtils.currentLine=1507371;
 //BA.debugLineNum = 1507371;BA.debugLine="astream.Write(b)       				' send the byte";
__ref._astream /*anywheresoftware.b4a.randomaccessfile.AsyncStreams*/ .Write(_b);
RDebugUtils.currentLine=1507372;
 //BA.debugLineNum = 1507372;BA.debugLine="Sleep(PACKET_DELAY_MS) 			   	' small delay bet";
parent.__c.Sleep(ba,new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "b4xmainpage", "sendfirmware"),__ref._packet_delay_ms /*int*/ );
this.state = 33;
return;
case 33:
//C
this.state = 32;
;
 if (true) break;
if (true) break;

case 25:
//C
this.state = 28;
;
RDebugUtils.currentLine=1507376;
 //BA.debugLineNum = 1507376;BA.debugLine="prgBar.Progress = Min(1, (i + BLOCK_SIZE) / firm";
__ref._prgbar /*anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper*/ .setProgress(parent.__c.Min(1,(_i+__ref._block_size /*int*/ )/(double)__ref._firmware /*byte[]*/ .length));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=1507379;
 //BA.debugLineNum = 1507379;BA.debugLine="LogMessage(\"FirmwareUpload\", \"Firmware upload com";
__ref._logmessage /*String*/ (null,"FirmwareUpload","Firmware upload complete!");
RDebugUtils.currentLine=1507382;
 //BA.debugLineNum = 1507382;BA.debugLine="End Sub";
if (true) break;

            }
        }
    }
}
public String  _initialize(b4j.example.b4xmainpage __ref,anywheresoftware.b4a.BA _ba) throws Exception{
__ref = this;
innerInitialize(_ba);
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "initialize", false))
	 {return ((String) Debug.delegate(ba, "initialize", new Object[] {_ba}));}
RDebugUtils.currentLine=524288;
 //BA.debugLineNum = 524288;BA.debugLine="Public Sub Initialize";
RDebugUtils.currentLine=524289;
 //BA.debugLineNum = 524289;BA.debugLine="serial1.Initialize(\"serial\")";
__ref._serial1 /*anywheresoftware.b4j.serial.Serial*/ .Initialize("serial");
RDebugUtils.currentLine=524290;
 //BA.debugLineNum = 524290;BA.debugLine="End Sub";
return "";
}
public boolean  _verifyfirmware(b4j.example.b4xmainpage __ref) throws Exception{
__ref = this;
RDebugUtils.currentModule="b4xmainpage";
if (Debug.shouldDelegate(ba, "verifyfirmware", false))
	 {return ((Boolean) Debug.delegate(ba, "verifyfirmware", null));}
int _i = 0;
RDebugUtils.currentLine=1638400;
 //BA.debugLineNum = 1638400;BA.debugLine="Sub VerifyFirmware() As Boolean";
RDebugUtils.currentLine=1638402;
 //BA.debugLineNum = 1638402;BA.debugLine="If firmware.Length <> firmwareVerify.Length Then";
if (__ref._firmware /*byte[]*/ .length!=__ref._firmwareverify /*byte[]*/ .length) { 
RDebugUtils.currentLine=1638403;
 //BA.debugLineNum = 1638403;BA.debugLine="Return False";
if (true) return __c.False;
 };
RDebugUtils.currentLine=1638407;
 //BA.debugLineNum = 1638407;BA.debugLine="For i = 0 To firmware.Length - 1";
{
final int step4 = 1;
final int limit4 = (int) (__ref._firmware /*byte[]*/ .length-1);
_i = (int) (0) ;
for (;_i <= limit4 ;_i = _i + step4 ) {
RDebugUtils.currentLine=1638408;
 //BA.debugLineNum = 1638408;BA.debugLine="If firmware(i) <> firmwareVerify(i) Then";
if (__ref._firmware /*byte[]*/ [_i]!=__ref._firmwareverify /*byte[]*/ [_i]) { 
RDebugUtils.currentLine=1638409;
 //BA.debugLineNum = 1638409;BA.debugLine="LogMessage(\"Status\", \"Mismatch at byte \" & i &";
__ref._logmessage /*String*/ (null,"Status","Mismatch at byte "+BA.NumberToString(_i)+": firmware = "+__ref._bytestohexstring2 /*String*/ (null,__ref._firmware /*byte[]*/ [_i])+" vs verify = "+__ref._bytestohexstring2 /*String*/ (null,__ref._firmwareverify /*byte[]*/ [_i]));
RDebugUtils.currentLine=1638412;
 //BA.debugLineNum = 1638412;BA.debugLine="Return False";
if (true) return __c.False;
 };
 }
};
RDebugUtils.currentLine=1638417;
 //BA.debugLineNum = 1638417;BA.debugLine="Return True";
if (true) return __c.True;
RDebugUtils.currentLine=1638418;
 //BA.debugLineNum = 1638418;BA.debugLine="End Sub";
return false;
}
}