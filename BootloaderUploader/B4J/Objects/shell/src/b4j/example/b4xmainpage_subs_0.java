package b4j.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class b4xmainpage_subs_0 {


public static RemoteObject  _appendbytes(RemoteObject __ref,RemoteObject _target,RemoteObject _data) throws Exception{
try {
		Debug.PushSubsStack("AppendBytes (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,99);
if (RapidSub.canDelegate("appendbytes")) { return __ref.runUserSub(false, "b4xmainpage","appendbytes", __ref, _target, _data);}
RemoteObject _totallength = RemoteObject.createImmutable(0);
RemoteObject _newarray = null;
RemoteObject _i = RemoteObject.createImmutable(0);
RemoteObject _startlen = RemoteObject.createImmutable(0);
Debug.locals.put("target", _target);
Debug.locals.put("data", _data);
 BA.debugLineNum = 99;BA.debugLine="Sub AppendBytes(target() As Byte, data() As Byte)";
Debug.ShouldStop(4);
 BA.debugLineNum = 101;BA.debugLine="Dim totalLength As Int = target.Length + data.Len";
Debug.ShouldStop(16);
_totallength = RemoteObject.solve(new RemoteObject[] {_target.getField(true,"length"),_data.getField(true,"length")}, "+",1, 1);Debug.locals.put("totalLength", _totallength);Debug.locals.put("totalLength", _totallength);
 BA.debugLineNum = 102;BA.debugLine="If totalLength = 0 Then Return Array As Byte() '";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",_totallength,BA.numberCast(double.class, 0))) { 
if (true) return RemoteObject.createNewArray("byte",new int[] {0},new Object[] {});};
 BA.debugLineNum = 105;BA.debugLine="Dim newArray(totalLength) As Byte";
Debug.ShouldStop(256);
_newarray = RemoteObject.createNewArray ("byte", new int[] {_totallength.<Integer>get().intValue()}, new Object[]{});Debug.locals.put("newArray", _newarray);
 BA.debugLineNum = 111;BA.debugLine="Dim i As Int";
Debug.ShouldStop(16384);
_i = RemoteObject.createImmutable(0);Debug.locals.put("i", _i);
 BA.debugLineNum = 112;BA.debugLine="For i = 0 To target.Length - 1";
Debug.ShouldStop(32768);
{
final int step5 = 1;
final int limit5 = RemoteObject.solve(new RemoteObject[] {_target.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step5 > 0 && _i.<Integer>get().intValue() <= limit5) || (step5 < 0 && _i.<Integer>get().intValue() >= limit5) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step5))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 113;BA.debugLine="newArray(i) = target(i)";
Debug.ShouldStop(65536);
_newarray.setArrayElement (_target.getArrayElement(true,_i),_i);
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 116;BA.debugLine="Dim StartLen As Int = target.Length";
Debug.ShouldStop(524288);
_startlen = _target.getField(true,"length");Debug.locals.put("StartLen", _startlen);Debug.locals.put("StartLen", _startlen);
 BA.debugLineNum = 119;BA.debugLine="For i = 0 To data.Length - 1";
Debug.ShouldStop(4194304);
{
final int step9 = 1;
final int limit9 = RemoteObject.solve(new RemoteObject[] {_data.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = BA.numberCast(int.class, 0) ;
for (;(step9 > 0 && _i.<Integer>get().intValue() <= limit9) || (step9 < 0 && _i.<Integer>get().intValue() >= limit9) ;_i = RemoteObject.createImmutable((int)(0 + _i.<Integer>get().intValue() + step9))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 120;BA.debugLine="newArray(StartLen + i) = data(i)";
Debug.ShouldStop(8388608);
_newarray.setArrayElement (_data.getArrayElement(true,_i),RemoteObject.solve(new RemoteObject[] {_startlen,_i}, "+",1, 1));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 123;BA.debugLine="Return newArray";
Debug.ShouldStop(67108864);
if (true) return _newarray;
 BA.debugLineNum = 124;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_error(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("AStream_Error (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,190);
if (RapidSub.canDelegate("astream_error")) { return __ref.runUserSub(false, "b4xmainpage","astream_error", __ref);}
 BA.debugLineNum = 190;BA.debugLine="Sub AStream_Error";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="LogMessage(\"Status\", \"Error: \" & LastException)";
Debug.ShouldStop(1073741824);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error: "),b4xmainpage.__c.runMethod(false,"LastException",__ref.getField(false, "ba")))));
 BA.debugLineNum = 192;BA.debugLine="AStream_Terminated";
Debug.ShouldStop(-2147483648);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_astream_terminated" /*RemoteObject*/ );
 BA.debugLineNum = 193;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_newdata(RemoteObject __ref,RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("AStream_NewData (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,84);
if (RapidSub.canDelegate("astream_newdata")) { return __ref.runUserSub(false, "b4xmainpage","astream_newdata", __ref, _buffer);}
Debug.locals.put("Buffer", _buffer);
 BA.debugLineNum = 84;BA.debugLine="Sub AStream_NewData (Buffer() As Byte)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 86;BA.debugLine="rxBufferString = rxBufferString & BytesToString(B";
Debug.ShouldStop(2097152);
__ref.setField ("_rxbufferstring" /*RemoteObject*/ ,RemoteObject.concat(__ref.getField(true,"_rxbufferstring" /*RemoteObject*/ ),b4xmainpage.__c.runMethod(true,"BytesToString",(Object)(_buffer),(Object)(BA.numberCast(int.class, 0)),(Object)(_buffer.getField(true,"length")),(Object)(RemoteObject.createImmutable("UTF8")))));
 BA.debugLineNum = 89;BA.debugLine="rxBuffer = AppendBytes(rxBuffer, Buffer)";
Debug.ShouldStop(16777216);
__ref.setField ("_rxbuffer" /*RemoteObject*/ ,__ref.runClassMethod (b4j.example.b4xmainpage.class, "_appendbytes" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_rxbuffer" /*RemoteObject*/ )),(Object)(_buffer)));
 BA.debugLineNum = 92;BA.debugLine="If rxBufferString.Contains(\">\") Then";
Debug.ShouldStop(134217728);
if (__ref.getField(true,"_rxbufferstring" /*RemoteObject*/ ).runMethod(true,"contains",(Object)(RemoteObject.createImmutable(">"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 93;BA.debugLine="HandleMessage(rxBufferString, rxBuffer)";
Debug.ShouldStop(268435456);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_handlemessage" /*void*/ ,(Object)(__ref.getField(true,"_rxbufferstring" /*RemoteObject*/ )),(Object)(__ref.getField(false,"_rxbuffer" /*RemoteObject*/ )));
 BA.debugLineNum = 94;BA.debugLine="rxBufferString = \"\"";
Debug.ShouldStop(536870912);
__ref.setField ("_rxbufferstring" /*RemoteObject*/ ,BA.ObjectToString(""));
 BA.debugLineNum = 95;BA.debugLine="rxBuffer = Array As Byte() ' Resets to an empty";
Debug.ShouldStop(1073741824);
__ref.setField ("_rxbuffer" /*RemoteObject*/ ,RemoteObject.createNewArray("byte",new int[] {0},new Object[] {}));
 };
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _astream_terminated(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("AStream_Terminated (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,194);
if (RapidSub.canDelegate("astream_terminated")) { return __ref.runUserSub(false, "b4xmainpage","astream_terminated", __ref);}
 BA.debugLineNum = 194;BA.debugLine="Sub AStream_Terminated";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="blnAppExitAstreamError = True";
Debug.ShouldStop(4);
__ref.setField ("_blnappexitastreamerror" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 197;BA.debugLine="If astream.IsInitialized Then";
Debug.ShouldStop(16);
if (__ref.getField(false,"_astream" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 198;BA.debugLine="astream.Close";
Debug.ShouldStop(32);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 199;BA.debugLine="serial1.Close";
Debug.ShouldStop(64);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("Close");
 };
 BA.debugLineNum = 201;BA.debugLine="EnableButtons";
Debug.ShouldStop(256);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_enablebuttons" /*RemoteObject*/ );
 BA.debugLineNum = 202;BA.debugLine="LogMessage(\"Status\", \"Connection is broken.\")";
Debug.ShouldStop(512);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Connection is broken.")));
 BA.debugLineNum = 203;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _b4xpage_closerequest(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("B4XPage_CloseRequest (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,62);
if (RapidSub.canDelegate("b4xpage_closerequest")) { return __ref.runUserSub(false, "b4xmainpage","b4xpage_closerequest", __ref);}
ResumableSub_B4XPage_CloseRequest rsub = new ResumableSub_B4XPage_CloseRequest(null,__ref);
rsub.remoteResumableSub = anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSubForFilter();
rsub.resume(null, null);
return RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.keywords.Common.ResumableSubWrapper"), rsub.remoteResumableSub);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_B4XPage_CloseRequest extends BA.ResumableSub {
public ResumableSub_B4XPage_CloseRequest(b4j.example.b4xmainpage parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4j.example.b4xmainpage parent;
RemoteObject _sf4 = RemoteObject.declareNull("Object");
RemoteObject _ret3 = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("B4XPage_CloseRequest (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,62);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
{
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,RemoteObject.createImmutable(null));return;}
case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 65;BA.debugLine="If blnProgrammingInProgress = True Then";
Debug.ShouldStop(1);
if (true) break;

case 1:
//if
this.state = 8;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnprogramminginprogress" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 66;BA.debugLine="Dim sf4 As Object = xui.Msgbox2Async(\"Flash in p";
Debug.ShouldStop(2);
_sf4 = __ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(false,"Msgbox2Async",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Flash in progress!")),(Object)(BA.ObjectToString("Quit?")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((parent.__c.getField(false,"Null"))));Debug.locals.put("sf4", _sf4);Debug.locals.put("sf4", _sf4);
 BA.debugLineNum = 67;BA.debugLine="Wait For (sf4) Msgbox_Result(ret3 As Int)";
Debug.ShouldStop(4);
parent.__c.runVoidMethod ("WaitFor","msgbox_result", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xmainpage", "b4xpage_closerequest"), _sf4);
this.state = 12;
return;
case 12:
//C
this.state = 4;
_ret3 = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("ret3", _ret3);
;
 BA.debugLineNum = 69;BA.debugLine="If ret3 = xui.DialogResponse_Negative Then";
Debug.ShouldStop(16);
if (true) break;

case 4:
//if
this.state = 7;
if (RemoteObject.solveBoolean("=",_ret3,BA.numberCast(double.class, __ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"DialogResponse_Negative")))) { 
this.state = 6;
}if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 70;BA.debugLine="Return False  ' will not exit";
Debug.ShouldStop(32);
if (true) {
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(parent.__c.getField(true,"False")));return;};
 if (true) break;

case 7:
//C
this.state = 8;
;
 if (true) break;
;
 BA.debugLineNum = 75;BA.debugLine="If astream.IsInitialized Then";
Debug.ShouldStop(1024);

case 8:
//if
this.state = 11;
if (__ref.getField(false,"_astream" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 76;BA.debugLine="astream.Close";
Debug.ShouldStop(2048);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 77;BA.debugLine="serial1.Close";
Debug.ShouldStop(4096);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("Close");
 if (true) break;

case 11:
//C
this.state = -1;
;
 BA.debugLineNum = 80;BA.debugLine="Return True";
Debug.ShouldStop(32768);
if (true) {
parent.__c.runVoidMethod ("ReturnFromResumableSub",this.remoteResumableSub,(parent.__c.getField(true,"True")));return;};
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _msgbox_result(RemoteObject __ref,RemoteObject _ret3) throws Exception{
}
public static RemoteObject  _b4xpage_created(RemoteObject __ref,RemoteObject _root1) throws Exception{
try {
		Debug.PushSubsStack("B4XPage_Created (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,54);
if (RapidSub.canDelegate("b4xpage_created")) { return __ref.runUserSub(false, "b4xmainpage","b4xpage_created", __ref, _root1);}
Debug.locals.put("Root1", _root1);
 BA.debugLineNum = 54;BA.debugLine="Private Sub B4XPage_Created (Root1 As B4XView)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="Root = Root1";
Debug.ShouldStop(4194304);
__ref.setField ("_root" /*RemoteObject*/ ,_root1);
 BA.debugLineNum = 56;BA.debugLine="Root.LoadLayout(\"MainPage\")";
Debug.ShouldStop(8388608);
__ref.getField(false,"_root" /*RemoteObject*/ ).runVoidMethodAndSync ("LoadLayout",(Object)(RemoteObject.createImmutable("MainPage")),__ref.getField(false, "ba"));
 BA.debugLineNum = 57;BA.debugLine="cmbPort.Items.AddAll(serial1.ListPorts)";
Debug.ShouldStop(16777216);
__ref.getField(false,"_cmbport" /*RemoteObject*/ ).runMethod(false,"getItems").runVoidMethod ("AddAll",(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).runMethod(false,"ListPorts")));
 BA.debugLineNum = 58;BA.debugLine="B4XPages.SetTitle(Me, \"PIC16F88 Bootloader Upload";
Debug.ShouldStop(33554432);
b4xmainpage._b4xpages.runVoidMethod ("_settitle" /*RemoteObject*/ ,(Object)(__ref),(Object)((RemoteObject.createImmutable("PIC16F88 Bootloader Upload"))));
 BA.debugLineNum = 59;BA.debugLine="B4XPages.GetNativeParent(Me).WindowHeight = 700";
Debug.ShouldStop(67108864);
b4xmainpage._b4xpages.runMethod(false,"_getnativeparent" /*RemoteObject*/ ,(Object)(__ref)).runMethod(true,"setWindowHeight",BA.numberCast(double.class, 700));
 BA.debugLineNum = 60;BA.debugLine="B4XPages.GetNativeParent(Me).WindowWidth = 600";
Debug.ShouldStop(134217728);
b4xmainpage._b4xpages.runMethod(false,"_getnativeparent" /*RemoteObject*/ ,(Object)(__ref)).runMethod(true,"setWindowWidth",BA.numberCast(double.class, 600));
 BA.debugLineNum = 61;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _btnflash_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnFlash_Click (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,317);
if (RapidSub.canDelegate("btnflash_click")) { __ref.runUserSub(false, "b4xmainpage","btnflash_click", __ref); return;}
ResumableSub_btnFlash_Click rsub = new ResumableSub_btnFlash_Click(null,__ref);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_btnFlash_Click extends BA.ResumableSub {
public ResumableSub_btnFlash_Click(b4j.example.b4xmainpage parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4j.example.b4xmainpage parent;
RemoteObject _sf6 = RemoteObject.declareNull("Object");
RemoteObject _ret3 = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("btnFlash_Click (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,317);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 318;BA.debugLine="If btnOpen.Text = \"Open Port\" Then";
Debug.ShouldStop(536870912);
if (true) break;

case 1:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"getText"),BA.ObjectToString("Open Port"))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 16;
 BA.debugLineNum = 319;BA.debugLine="xui.Msgbox2Async(\"Please choose and open port!\",";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_xui" /*RemoteObject*/ ).runVoidMethod ("Msgbox2Async",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Please choose and open port!")),(Object)(BA.ObjectToString("Port Closed")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((parent.__c.getField(false,"Null"))));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 321;BA.debugLine="If btnFlash.Text = \"Flash\" Then";
Debug.ShouldStop(1);
if (true) break;

case 6:
//if
this.state = 15;
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"getText"),BA.ObjectToString("Flash"))) { 
this.state = 8;
}else {
this.state = 10;
}if (true) break;

case 8:
//C
this.state = 15;
 BA.debugLineNum = 322;BA.debugLine="txtLog.Text = \"\"";
Debug.ShouldStop(2);
__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString(""));
 BA.debugLineNum = 323;BA.debugLine="btnFlash.Text = \"Stop\"";
Debug.ShouldStop(4);
__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString("Stop"));
 BA.debugLineNum = 324;BA.debugLine="xui.Msgbox2Async(\"16F88 Application will restar";
Debug.ShouldStop(8);
__ref.getField(false,"_xui" /*RemoteObject*/ ).runVoidMethod ("Msgbox2Async",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("16F88 Application will restart to bootloader.  If not, then power off and on the PIC16F88.")),(Object)(BA.ObjectToString("Attention!")),(Object)(BA.ObjectToString("Ok")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("")),(Object)((parent.__c.getField(false,"Null"))));
 BA.debugLineNum = 325;BA.debugLine="SendHandshakeLoop";
Debug.ShouldStop(16);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_sendhandshakeloop" /*void*/ );
 if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 327;BA.debugLine="Dim sf6 As Object = xui.Msgbox2Async(\"Flash in";
Debug.ShouldStop(64);
_sf6 = __ref.getField(false,"_xui" /*RemoteObject*/ ).runMethod(false,"Msgbox2Async",__ref.getField(false, "ba"),(Object)(BA.ObjectToString("Flash in progress!")),(Object)(BA.ObjectToString("Stop?")),(Object)(BA.ObjectToString("Yes")),(Object)(BA.ObjectToString("")),(Object)(BA.ObjectToString("No")),(Object)((parent.__c.getField(false,"Null"))));Debug.locals.put("sf6", _sf6);Debug.locals.put("sf6", _sf6);
 BA.debugLineNum = 328;BA.debugLine="Wait For (sf6) Msgbox_Result(ret3 As Int)";
Debug.ShouldStop(128);
parent.__c.runVoidMethod ("WaitFor","msgbox_result", __ref.getField(false, "ba"), anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xmainpage", "btnflash_click"), _sf6);
this.state = 17;
return;
case 17:
//C
this.state = 11;
_ret3 = (RemoteObject) result.getArrayElement(true,RemoteObject.createImmutable(1));Debug.locals.put("ret3", _ret3);
;
 BA.debugLineNum = 330;BA.debugLine="If ret3 = xui.DialogResponse_Positive Then";
Debug.ShouldStop(512);
if (true) break;

case 11:
//if
this.state = 14;
if (RemoteObject.solveBoolean("=",_ret3,BA.numberCast(double.class, __ref.getField(false,"_xui" /*RemoteObject*/ ).getField(true,"DialogResponse_Positive")))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 331;BA.debugLine="LogMessage(\"Status\", \"User stop flash!\")";
Debug.ShouldStop(1024);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("User stop flash!")));
 BA.debugLineNum = 332;BA.debugLine="EnableButtons";
Debug.ShouldStop(2048);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_enablebuttons" /*RemoteObject*/ );
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
 BA.debugLineNum = 336;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _btnloadfile_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnLoadFile_Click (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,235);
if (RapidSub.canDelegate("btnloadfile_click")) { return __ref.runUserSub(false, "b4xmainpage","btnloadfile_click", __ref);}
 BA.debugLineNum = 235;BA.debugLine="Private Sub btnLoadFile_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 236;BA.debugLine="firmware = Array As Byte() ' Resets to an empty a";
Debug.ShouldStop(2048);
__ref.setField ("_firmware" /*RemoteObject*/ ,RemoteObject.createNewArray("byte",new int[] {0},new Object[] {}));
 BA.debugLineNum = 237;BA.debugLine="jframe.InitializeNewInstance(\"javax.swing.JFrame\"";
Debug.ShouldStop(4096);
__ref.getField(false,"_jframe" /*RemoteObject*/ ).runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("javax.swing.JFrame")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable(""))})));
 BA.debugLineNum = 238;BA.debugLine="openFileDialog";
Debug.ShouldStop(8192);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_openfiledialog" /*RemoteObject*/ );
 BA.debugLineNum = 239;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnopen_click(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("btnOpen_Click (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,209);
if (RapidSub.canDelegate("btnopen_click")) { return __ref.runUserSub(false, "b4xmainpage","btnopen_click", __ref);}
 BA.debugLineNum = 209;BA.debugLine="Sub btnOpen_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 212;BA.debugLine="If btnOpen.Text = \"Open Port\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"getText"),BA.ObjectToString("Open Port"))) { 
 BA.debugLineNum = 213;BA.debugLine="Try";
Debug.ShouldStop(1048576);
try { BA.debugLineNum = 214;BA.debugLine="serial1.Open(cmbPort.Value)";
Debug.ShouldStop(2097152);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("Open",(Object)(BA.ObjectToString(__ref.getField(false,"_cmbport" /*RemoteObject*/ ).runMethod(false,"getValue"))));
 BA.debugLineNum = 215;BA.debugLine="serial1.SetParams(serial1.BAUDRATE_57600, seria";
Debug.ShouldStop(4194304);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("SetParams",(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).getField(true,"BAUDRATE_57600")),(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).getField(true,"DATABITS_8")),(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).getField(true,"STOPBITS_1")),(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).getField(true,"PARITY_NONE")));
 BA.debugLineNum = 216;BA.debugLine="astream.Initialize(serial1.GetInputStream, seri";
Debug.ShouldStop(8388608);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Initialize",__ref.getField(false, "ba"),(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).runMethod(false,"GetInputStream")),(Object)(__ref.getField(false,"_serial1" /*RemoteObject*/ ).runMethod(false,"GetOutputStream")),(Object)(RemoteObject.createImmutable("astream")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e7) {
			BA.rdebugUtils.runVoidMethod("setLastException",__ref.getField(false, "ba"), e7.toString()); BA.debugLineNum = 218;BA.debugLine="LogMessage(\"Status\", \"Error Open Port\" & LastEx";
Debug.ShouldStop(33554432);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Error Open Port"),b4xmainpage.__c.runMethod(false,"LastException",__ref.getField(false, "ba")))));
 BA.debugLineNum = 219;BA.debugLine="Return";
Debug.ShouldStop(67108864);
if (true) return RemoteObject.createImmutable("");
 };
 BA.debugLineNum = 221;BA.debugLine="btnOpen.Text = \"Close Port\"";
Debug.ShouldStop(268435456);
__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString("Close Port"));
 BA.debugLineNum = 222;BA.debugLine="LogMessage(\"Status\", \"Port Opened\")";
Debug.ShouldStop(536870912);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Port Opened")));
 }else {
 BA.debugLineNum = 226;BA.debugLine="If astream.IsInitialized Then";
Debug.ShouldStop(2);
if (__ref.getField(false,"_astream" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 227;BA.debugLine="astream.Close";
Debug.ShouldStop(4);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Close");
 BA.debugLineNum = 228;BA.debugLine="serial1.Close";
Debug.ShouldStop(8);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("Close");
 };
 BA.debugLineNum = 230;BA.debugLine="btnOpen.Text = \"Open Port\"";
Debug.ShouldStop(32);
__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString("Open Port"));
 BA.debugLineNum = 231;BA.debugLine="LogMessage(\"Status\", \"Port Closed\")";
Debug.ShouldStop(64);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Port Closed")));
 };
 BA.debugLineNum = 233;BA.debugLine="End Sub";
Debug.ShouldStop(256);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bytestohexstring(RemoteObject __ref,RemoteObject _b) throws Exception{
try {
		Debug.PushSubsStack("BytesToHexString (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,497);
if (RapidSub.canDelegate("bytestohexstring")) { return __ref.runUserSub(false, "b4xmainpage","bytestohexstring", __ref, _b);}
RemoteObject _sb = RemoteObject.declareNull("anywheresoftware.b4a.keywords.StringBuilderWrapper");
RemoteObject _bt = RemoteObject.createImmutable((byte)0);
RemoteObject _bytestring = RemoteObject.createImmutable("");
Debug.locals.put("b", _b);
 BA.debugLineNum = 497;BA.debugLine="Sub BytesToHexString(b() As Byte) As String";
Debug.ShouldStop(65536);
 BA.debugLineNum = 498;BA.debugLine="Dim sb As StringBuilder";
Debug.ShouldStop(131072);
_sb = RemoteObject.createNew ("anywheresoftware.b4a.keywords.StringBuilderWrapper");Debug.locals.put("sb", _sb);
 BA.debugLineNum = 499;BA.debugLine="sb.Initialize";
Debug.ShouldStop(262144);
_sb.runVoidMethod ("Initialize");
 BA.debugLineNum = 500;BA.debugLine="For Each bt As Byte In b";
Debug.ShouldStop(524288);
{
final RemoteObject group3 = _b;
final int groupLen3 = group3.getField(true,"length").<Integer>get()
;int index3 = 0;
;
for (; index3 < groupLen3;index3++){
_bt = group3.getArrayElement(true,RemoteObject.createImmutable(index3));Debug.locals.put("bt", _bt);
Debug.locals.put("bt", _bt);
 BA.debugLineNum = 501;BA.debugLine="Dim byteString As String";
Debug.ShouldStop(1048576);
_bytestring = RemoteObject.createImmutable("");Debug.locals.put("byteString", _bytestring);
 BA.debugLineNum = 502;BA.debugLine="byteString = Bit.ToHexString(Bit.And(bt, 0xFF))";
Debug.ShouldStop(2097152);
_bytestring = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ToHexString",(Object)(b4xmainpage.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, _bt)),(Object)(BA.numberCast(int.class, ((int)0xff))))));Debug.locals.put("byteString", _bytestring);
 BA.debugLineNum = 503;BA.debugLine="If byteString.Length = 1 Then byteString = \"0\" &";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",_bytestring.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
_bytestring = RemoteObject.concat(RemoteObject.createImmutable("0"),_bytestring);Debug.locals.put("byteString", _bytestring);};
 BA.debugLineNum = 504;BA.debugLine="sb.Append(byteString).Append(\" \")";
Debug.ShouldStop(8388608);
_sb.runMethod(false,"Append",(Object)(_bytestring)).runVoidMethod ("Append",(Object)(RemoteObject.createImmutable(" ")));
 }
}Debug.locals.put("bt", _bt);
;
 BA.debugLineNum = 506;BA.debugLine="Return sb.ToString.Trim.ToUpperCase";
Debug.ShouldStop(33554432);
if (true) return _sb.runMethod(true,"ToString").runMethod(true,"trim").runMethod(true,"toUpperCase");
 BA.debugLineNum = 507;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _bytestohexstring2(RemoteObject __ref,RemoteObject _b) throws Exception{
try {
		Debug.PushSubsStack("BytesToHexString2 (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,508);
if (RapidSub.canDelegate("bytestohexstring2")) { return __ref.runUserSub(false, "b4xmainpage","bytestohexstring2", __ref, _b);}
RemoteObject _bytestring = RemoteObject.createImmutable("");
Debug.locals.put("b", _b);
 BA.debugLineNum = 508;BA.debugLine="Sub BytesToHexString2(b As Byte) As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 509;BA.debugLine="Dim byteString As String";
Debug.ShouldStop(268435456);
_bytestring = RemoteObject.createImmutable("");Debug.locals.put("byteString", _bytestring);
 BA.debugLineNum = 511;BA.debugLine="byteString = Bit.ToHexString(Bit.And(b, 0xFF))";
Debug.ShouldStop(1073741824);
_bytestring = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ToHexString",(Object)(b4xmainpage.__c.getField(false,"Bit").runMethod(true,"And",(Object)(BA.numberCast(int.class, _b)),(Object)(BA.numberCast(int.class, ((int)0xff))))));Debug.locals.put("byteString", _bytestring);
 BA.debugLineNum = 512;BA.debugLine="If byteString.Length = 1 Then byteString = \"0\" &";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",_bytestring.runMethod(true,"length"),BA.numberCast(double.class, 1))) { 
_bytestring = RemoteObject.concat(RemoteObject.createImmutable("0"),_bytestring);Debug.locals.put("byteString", _bytestring);};
 BA.debugLineNum = 514;BA.debugLine="Return byteString.ToUpperCase";
Debug.ShouldStop(2);
if (true) return _bytestring.runMethod(true,"toUpperCase");
 BA.debugLineNum = 515;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _class_globals(RemoteObject __ref) throws Exception{
 //BA.debugLineNum = 8;BA.debugLine="Sub Class_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private Const START_ADDR_FLASH As Int = 0x0600";
b4xmainpage._start_addr_flash = BA.numberCast(int.class, ((int)0x0600));__ref.setField("_start_addr_flash",b4xmainpage._start_addr_flash);
 //BA.debugLineNum = 10;BA.debugLine="Private Const END_ADDR_FLASH As Int = 0x0FFF			'";
b4xmainpage._end_addr_flash = BA.numberCast(int.class, ((int)0x0fff));__ref.setField("_end_addr_flash",b4xmainpage._end_addr_flash);
 //BA.debugLineNum = 11;BA.debugLine="Private Const WORDS_PER_PACKET As Int = 4				' To";
b4xmainpage._words_per_packet = BA.numberCast(int.class, 4);__ref.setField("_words_per_packet",b4xmainpage._words_per_packet);
 //BA.debugLineNum = 12;BA.debugLine="Private Const BLOCK_SIZE As Int = WORDS_PER_PACKE";
b4xmainpage._block_size = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_words_per_packet" /*RemoteObject*/ ),RemoteObject.createImmutable(2)}, "*",0, 1);__ref.setField("_block_size",b4xmainpage._block_size);
 //BA.debugLineNum = 13;BA.debugLine="Private Const PACKET_DELAY_MS As Int = 2				' Wri";
b4xmainpage._packet_delay_ms = BA.numberCast(int.class, 2);__ref.setField("_packet_delay_ms",b4xmainpage._packet_delay_ms);
 //BA.debugLineNum = 14;BA.debugLine="Private Const HANDSHAKE_DELAY_MS As Int = 200";
b4xmainpage._handshake_delay_ms = BA.numberCast(int.class, 200);__ref.setField("_handshake_delay_ms",b4xmainpage._handshake_delay_ms);
 //BA.debugLineNum = 15;BA.debugLine="Private Const MSB_WORD_ADDR As Int = 0x3F				' 14";
b4xmainpage._msb_word_addr = BA.numberCast(int.class, ((int)0x3f));__ref.setField("_msb_word_addr",b4xmainpage._msb_word_addr);
 //BA.debugLineNum = 16;BA.debugLine="Private Const EXPECTED_FIRMWARE_BYTES As Int = (E";
b4xmainpage._expected_firmware_bytes = RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_end_addr_flash" /*RemoteObject*/ ),__ref.getField(true,"_start_addr_flash" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-+",2, 1)),RemoteObject.createImmutable(2)}, "*",0, 1);__ref.setField("_expected_firmware_bytes",b4xmainpage._expected_firmware_bytes);
 //BA.debugLineNum = 18;BA.debugLine="Private serial1 As Serial								' UART COM";
b4xmainpage._serial1 = RemoteObject.createNew ("anywheresoftware.b4j.serial.Serial");__ref.setField("_serial1",b4xmainpage._serial1);
 //BA.debugLineNum = 19;BA.debugLine="Private astream As AsyncStreams";
b4xmainpage._astream = RemoteObject.createNew ("anywheresoftware.b4a.randomaccessfile.AsyncStreams");__ref.setField("_astream",b4xmainpage._astream);
 //BA.debugLineNum = 20;BA.debugLine="Private jframe As JavaObject							' For file ope";
b4xmainpage._jframe = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");__ref.setField("_jframe",b4xmainpage._jframe);
 //BA.debugLineNum = 22;BA.debugLine="Private Root As B4XView";
b4xmainpage._root = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper");__ref.setField("_root",b4xmainpage._root);
 //BA.debugLineNum = 23;BA.debugLine="Private xui As XUI";
b4xmainpage._xui = RemoteObject.createNew ("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");__ref.setField("_xui",b4xmainpage._xui);
 //BA.debugLineNum = 25;BA.debugLine="Private btnFlash As Button";
b4xmainpage._btnflash = RemoteObject.createNew ("anywheresoftware.b4j.objects.ButtonWrapper");__ref.setField("_btnflash",b4xmainpage._btnflash);
 //BA.debugLineNum = 26;BA.debugLine="Private btnLoadFile As Button";
b4xmainpage._btnloadfile = RemoteObject.createNew ("anywheresoftware.b4j.objects.ButtonWrapper");__ref.setField("_btnloadfile",b4xmainpage._btnloadfile);
 //BA.debugLineNum = 27;BA.debugLine="Private btnOpen As Button";
b4xmainpage._btnopen = RemoteObject.createNew ("anywheresoftware.b4j.objects.ButtonWrapper");__ref.setField("_btnopen",b4xmainpage._btnopen);
 //BA.debugLineNum = 28;BA.debugLine="Private txtLog As TextArea";
b4xmainpage._txtlog = RemoteObject.createNew ("anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper");__ref.setField("_txtlog",b4xmainpage._txtlog);
 //BA.debugLineNum = 29;BA.debugLine="Private cmbPort As ComboBox";
b4xmainpage._cmbport = RemoteObject.createNew ("anywheresoftware.b4j.objects.ComboBoxWrapper");__ref.setField("_cmbport",b4xmainpage._cmbport);
 //BA.debugLineNum = 30;BA.debugLine="Private prgBar As ProgressBar";
b4xmainpage._prgbar = RemoteObject.createNew ("anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper");__ref.setField("_prgbar",b4xmainpage._prgbar);
 //BA.debugLineNum = 33;BA.debugLine="Private firmware() As Byte								' firmware bina";
b4xmainpage._firmware = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});__ref.setField("_firmware",b4xmainpage._firmware);
 //BA.debugLineNum = 34;BA.debugLine="Private firmwareVerify(EXPECTED_FIRMWARE_BYTES) A";
b4xmainpage._firmwareverify = RemoteObject.createNewArray ("byte", new int[] {__ref.getField(true,"_expected_firmware_bytes" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});__ref.setField("_firmwareverify",b4xmainpage._firmwareverify);
 //BA.debugLineNum = 35;BA.debugLine="Private cntVerify As Int								' Counter to dete";
b4xmainpage._cntverify = RemoteObject.createImmutable(0);__ref.setField("_cntverify",b4xmainpage._cntverify);
 //BA.debugLineNum = 36;BA.debugLine="Private blnVerifyRequest As Boolean						' Reques";
b4xmainpage._blnverifyrequest = RemoteObject.createImmutable(false);__ref.setField("_blnverifyrequest",b4xmainpage._blnverifyrequest);
 //BA.debugLineNum = 37;BA.debugLine="Private blnProgrammingInProgress As Boolean				'";
b4xmainpage._blnprogramminginprogress = RemoteObject.createImmutable(false);__ref.setField("_blnprogramminginprogress",b4xmainpage._blnprogramminginprogress);
 //BA.debugLineNum = 38;BA.debugLine="Private bln16F88HandShakeSuccess As Boolean				'";
b4xmainpage._bln16f88handshakesuccess = RemoteObject.createImmutable(false);__ref.setField("_bln16f88handshakesuccess",b4xmainpage._bln16f88handshakesuccess);
 //BA.debugLineNum = 39;BA.debugLine="Private bln16F88ExitTimeoutError As Boolean				'";
b4xmainpage._bln16f88exittimeouterror = RemoteObject.createImmutable(false);__ref.setField("_bln16f88exittimeouterror",b4xmainpage._bln16f88exittimeouterror);
 //BA.debugLineNum = 40;BA.debugLine="Private blnAppExitAstreamError	As Boolean				' As";
b4xmainpage._blnappexitastreamerror = RemoteObject.createImmutable(false);__ref.setField("_blnappexitastreamerror",b4xmainpage._blnappexitastreamerror);
 //BA.debugLineNum = 41;BA.debugLine="Private blnAppStopQuit As Boolean						' Exit loo";
b4xmainpage._blnappstopquit = RemoteObject.createImmutable(false);__ref.setField("_blnappstopquit",b4xmainpage._blnappstopquit);
 //BA.debugLineNum = 43;BA.debugLine="Private rxBufferString As String						' Buffer Ne";
b4xmainpage._rxbufferstring = RemoteObject.createImmutable("");__ref.setField("_rxbufferstring",b4xmainpage._rxbufferstring);
 //BA.debugLineNum = 44;BA.debugLine="Private rxBuffer() As Byte								' Buffer Newdat";
b4xmainpage._rxbuffer = RemoteObject.createNewArray ("byte", new int[] {0}, new Object[]{});__ref.setField("_rxbuffer",b4xmainpage._rxbuffer);
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _cmbport_selectedindexchanged(RemoteObject __ref,RemoteObject _index,RemoteObject _value) throws Exception{
try {
		Debug.PushSubsStack("cmbPort_SelectedIndexChanged (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,205);
if (RapidSub.canDelegate("cmbport_selectedindexchanged")) { return __ref.runUserSub(false, "b4xmainpage","cmbport_selectedindexchanged", __ref, _index, _value);}
Debug.locals.put("Index", _index);
Debug.locals.put("Value", _value);
 BA.debugLineNum = 205;BA.debugLine="Sub cmbPort_SelectedIndexChanged(Index As Int, Val";
Debug.ShouldStop(4096);
 BA.debugLineNum = 206;BA.debugLine="btnOpen.Enabled = Index > -1 'enable the button i";
Debug.ShouldStop(8192);
__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"setEnabled",BA.ObjectToBoolean(RemoteObject.solveBoolean(">",_index,BA.numberCast(double.class, -(double) (0 + 1)))));
 BA.debugLineNum = 207;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _converthexinteltobinaryrange(RemoteObject __ref,RemoteObject _filepath,RemoteObject _startaddr) throws Exception{
try {
		Debug.PushSubsStack("ConvertHexIntelToBinaryRange (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,261);
if (RapidSub.canDelegate("converthexinteltobinaryrange")) { return __ref.runUserSub(false, "b4xmainpage","converthexinteltobinaryrange", __ref, _filepath, _startaddr);}
RemoteObject _lines = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _startbyte = RemoteObject.createImmutable(0);
RemoteObject _firmwaredata = null;
int _i = 0;
RemoteObject _blndetectrecordavailable = RemoteObject.createImmutable(false);
RemoteObject _line = RemoteObject.createImmutable("");
RemoteObject _bytecount = RemoteObject.createImmutable(0);
RemoteObject _wordaddr = RemoteObject.createImmutable(0);
RemoteObject _recordtype = RemoteObject.createImmutable(0);
RemoteObject _byteaddr = RemoteObject.createImmutable(0);
RemoteObject _b = RemoteObject.createImmutable(0);
RemoteObject _arrayindex = RemoteObject.createImmutable(0);
Debug.locals.put("filepath", _filepath);
Debug.locals.put("startAddr", _startaddr);
 BA.debugLineNum = 261;BA.debugLine="Sub ConvertHexIntelToBinaryRange(filepath As Strin";
Debug.ShouldStop(16);
 BA.debugLineNum = 262;BA.debugLine="Dim lines As List = File.ReadList(\"\", filepath)";
Debug.ShouldStop(32);
_lines = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");
_lines = b4xmainpage.__c.getField(false,"File").runMethod(false,"ReadList",(Object)(BA.ObjectToString("")),(Object)(_filepath));Debug.locals.put("lines", _lines);Debug.locals.put("lines", _lines);
 BA.debugLineNum = 265;BA.debugLine="Dim startByte As Int = startAddr * 2";
Debug.ShouldStop(256);
_startbyte = RemoteObject.solve(new RemoteObject[] {_startaddr,RemoteObject.createImmutable(2)}, "*",0, 1);Debug.locals.put("startByte", _startbyte);Debug.locals.put("startByte", _startbyte);
 BA.debugLineNum = 268;BA.debugLine="Dim firmwareData(EXPECTED_FIRMWARE_BYTES) As Byte";
Debug.ShouldStop(2048);
_firmwaredata = RemoteObject.createNewArray ("byte", new int[] {__ref.getField(true,"_expected_firmware_bytes" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});Debug.locals.put("firmwareData", _firmwaredata);
 BA.debugLineNum = 271;BA.debugLine="For i = 0 To firmwareData.Length - 1 Step 2";
Debug.ShouldStop(16384);
{
final int step4 = 2;
final int limit4 = RemoteObject.solve(new RemoteObject[] {_firmwaredata.getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 272;BA.debugLine="firmwareData(i) = 0xFF";
Debug.ShouldStop(32768);
_firmwaredata.setArrayElement (BA.numberCast(byte.class, ((int)0xff)),BA.numberCast(int.class, _i));
 BA.debugLineNum = 273;BA.debugLine="firmwareData(i+1) = MSB_WORD_ADDR			' 0x3F on PI";
Debug.ShouldStop(65536);
_firmwaredata.setArrayElement (BA.numberCast(byte.class, __ref.getField(true,"_msb_word_addr" /*RemoteObject*/ )),RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(1)}, "+",1, 1));
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 277;BA.debugLine="Dim blnDetectRecordAvailable As Boolean = False";
Debug.ShouldStop(1048576);
_blndetectrecordavailable = b4xmainpage.__c.getField(true,"False");Debug.locals.put("blnDetectRecordAvailable", _blndetectrecordavailable);Debug.locals.put("blnDetectRecordAvailable", _blndetectrecordavailable);
 BA.debugLineNum = 280;BA.debugLine="For Each line As String In lines";
Debug.ShouldStop(8388608);
{
final RemoteObject group9 = _lines;
final int groupLen9 = group9.runMethod(true,"getSize").<Integer>get()
;int index9 = 0;
;
for (; index9 < groupLen9;index9++){
_line = BA.ObjectToString(group9.runMethod(false,"Get",index9));Debug.locals.put("line", _line);
Debug.locals.put("line", _line);
 BA.debugLineNum = 281;BA.debugLine="If line.Length = 0 Or line.CharAt(0) <> \":\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",_line.runMethod(true,"length"),BA.numberCast(double.class, 0)) || RemoteObject.solveBoolean("!",_line.runMethod(true,"charAt",(Object)(BA.numberCast(int.class, 0))),BA.ObjectToChar(":"))) { 
if (true) continue;};
 BA.debugLineNum = 283;BA.debugLine="Dim byteCount As Int = Bit.ParseInt(line.SubStri";
Debug.ShouldStop(67108864);
_bytecount = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ParseInt",(Object)(_line.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 1)),(Object)(BA.numberCast(int.class, 3)))),(Object)(BA.numberCast(int.class, 16)));Debug.locals.put("byteCount", _bytecount);Debug.locals.put("byteCount", _bytecount);
 BA.debugLineNum = 284;BA.debugLine="Dim wordAddr As Int = Bit.ParseInt(line.SubStrin";
Debug.ShouldStop(134217728);
_wordaddr = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ParseInt",(Object)(_line.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 3)),(Object)(BA.numberCast(int.class, 7)))),(Object)(BA.numberCast(int.class, 16)));Debug.locals.put("wordAddr", _wordaddr);Debug.locals.put("wordAddr", _wordaddr);
 BA.debugLineNum = 285;BA.debugLine="Dim recordType As Int = Bit.ParseInt(line.SubStr";
Debug.ShouldStop(268435456);
_recordtype = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ParseInt",(Object)(_line.runMethod(true,"substring",(Object)(BA.numberCast(int.class, 7)),(Object)(BA.numberCast(int.class, 9)))),(Object)(BA.numberCast(int.class, 16)));Debug.locals.put("recordType", _recordtype);Debug.locals.put("recordType", _recordtype);
 BA.debugLineNum = 288;BA.debugLine="If recordType <> 0 Then Continue";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("!",_recordtype,BA.numberCast(double.class, 0))) { 
if (true) continue;};
 BA.debugLineNum = 290;BA.debugLine="Dim byteAddr As Int = wordAddr";
Debug.ShouldStop(2);
_byteaddr = _wordaddr;Debug.locals.put("byteAddr", _byteaddr);Debug.locals.put("byteAddr", _byteaddr);
 BA.debugLineNum = 292;BA.debugLine="For i = 0 To byteCount - 1";
Debug.ShouldStop(8);
{
final int step16 = 1;
final int limit16 = RemoteObject.solve(new RemoteObject[] {_bytecount,RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step16 > 0 && _i <= limit16) || (step16 < 0 && _i >= limit16) ;_i = ((int)(0 + _i + step16))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 293;BA.debugLine="Dim b As Int = Bit.ParseInt(line.SubString2(9 +";
Debug.ShouldStop(16);
_b = b4xmainpage.__c.getField(false,"Bit").runMethod(true,"ParseInt",(Object)(_line.runMethod(true,"substring",(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(9),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(2)}, "+*",1, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(11),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(2)}, "+*",1, 1)))),(Object)(BA.numberCast(int.class, 16)));Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 294;BA.debugLine="Dim arrayIndex As Int = byteAddr - startByte +";
Debug.ShouldStop(32);
_arrayindex = RemoteObject.solve(new RemoteObject[] {_byteaddr,_startbyte,RemoteObject.createImmutable(_i)}, "-+",2, 1);Debug.locals.put("arrayIndex", _arrayindex);Debug.locals.put("arrayIndex", _arrayindex);
 BA.debugLineNum = 297;BA.debugLine="If arrayIndex >= 0 And arrayIndex < firmwareDat";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_arrayindex,BA.numberCast(double.class, 0)) && RemoteObject.solveBoolean("<",_arrayindex,BA.numberCast(double.class, _firmwaredata.getField(true,"length")))) { 
 BA.debugLineNum = 298;BA.debugLine="firmwareData(arrayIndex) = b";
Debug.ShouldStop(512);
_firmwaredata.setArrayElement (BA.numberCast(byte.class, _b),_arrayindex);
 BA.debugLineNum = 299;BA.debugLine="blnDetectRecordAvailable = True";
Debug.ShouldStop(1024);
_blndetectrecordavailable = b4xmainpage.__c.getField(true,"True");Debug.locals.put("blnDetectRecordAvailable", _blndetectrecordavailable);
 };
 }
}Debug.locals.put("i", _i);
;
 }
}Debug.locals.put("line", _line);
;
 BA.debugLineNum = 306;BA.debugLine="If blnDetectRecordAvailable Then";
Debug.ShouldStop(131072);
if (_blndetectrecordavailable.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 307;BA.debugLine="btnFlash.Enabled = True";
Debug.ShouldStop(262144);
__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 308;BA.debugLine="LogMessage(\"Status\", \"Firmware bytes: \" & firmwa";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Firmware bytes: "),_firmwaredata.getField(true,"length"))));
 }else {
 BA.debugLineNum = 310;BA.debugLine="btnFlash.Enabled = False";
Debug.ShouldStop(2097152);
__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 311;BA.debugLine="LogMessage(\"Status\", \"Conversion did not detect";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Conversion did not detect valid Intel HEX Record")));
 };
 BA.debugLineNum = 314;BA.debugLine="Return firmwareData";
Debug.ShouldStop(33554432);
if (true) return _firmwaredata;
 BA.debugLineNum = 315;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable(null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _disablebuttons(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("DisableButtons (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,464);
if (RapidSub.canDelegate("disablebuttons")) { return __ref.runUserSub(false, "b4xmainpage","disablebuttons", __ref);}
 BA.debugLineNum = 464;BA.debugLine="Sub DisableButtons";
Debug.ShouldStop(32768);
 BA.debugLineNum = 465;BA.debugLine="btnOpen.Enabled = False";
Debug.ShouldStop(65536);
__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 466;BA.debugLine="btnLoadFile.Enabled = False";
Debug.ShouldStop(131072);
__ref.getField(false,"_btnloadfile" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 467;BA.debugLine="cmbPort.Enabled = False";
Debug.ShouldStop(262144);
__ref.getField(false,"_cmbport" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 468;BA.debugLine="cntVerify = 0";
Debug.ShouldStop(524288);
__ref.setField ("_cntverify" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 469;BA.debugLine="blnProgrammingInProgress = True";
Debug.ShouldStop(1048576);
__ref.setField ("_blnprogramminginprogress" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 470;BA.debugLine="btnFlash.Text = \"Stop\"";
Debug.ShouldStop(2097152);
__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString("Stop"));
 BA.debugLineNum = 471;BA.debugLine="blnAppStopQuit = False";
Debug.ShouldStop(4194304);
__ref.setField ("_blnappstopquit" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 472;BA.debugLine="bln16F88HandShakeSuccess = False";
Debug.ShouldStop(8388608);
__ref.setField ("_bln16f88handshakesuccess" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 473;BA.debugLine="bln16F88ExitTimeoutError = False";
Debug.ShouldStop(16777216);
__ref.setField ("_bln16f88exittimeouterror" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 474;BA.debugLine="blnAppExitAstreamError = False";
Debug.ShouldStop(33554432);
__ref.setField ("_blnappexitastreamerror" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 475;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = False";
Debug.ShouldStop(67108864);
b4xmainpage._b4xpages.runMethod(false,"_getnativeparent" /*RemoteObject*/ ,(Object)(__ref)).runMethod(true,"setResizable",b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 476;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _enablebuttons(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("EnableButtons (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,477);
if (RapidSub.canDelegate("enablebuttons")) { return __ref.runUserSub(false, "b4xmainpage","enablebuttons", __ref);}
 BA.debugLineNum = 477;BA.debugLine="Sub EnableButtons";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 478;BA.debugLine="btnOpen.Enabled = True";
Debug.ShouldStop(536870912);
__ref.getField(false,"_btnopen" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 479;BA.debugLine="btnLoadFile.Enabled = True";
Debug.ShouldStop(1073741824);
__ref.getField(false,"_btnloadfile" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 480;BA.debugLine="cmbPort.Enabled = True";
Debug.ShouldStop(-2147483648);
__ref.getField(false,"_cmbport" /*RemoteObject*/ ).runMethod(true,"setEnabled",b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 481;BA.debugLine="blnVerifyRequest = False";
Debug.ShouldStop(1);
__ref.setField ("_blnverifyrequest" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 482;BA.debugLine="blnProgrammingInProgress = False";
Debug.ShouldStop(2);
__ref.setField ("_blnprogramminginprogress" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"False"));
 BA.debugLineNum = 483;BA.debugLine="btnFlash.Text = \"Flash\"";
Debug.ShouldStop(4);
__ref.getField(false,"_btnflash" /*RemoteObject*/ ).runMethod(true,"setText",BA.ObjectToString("Flash"));
 BA.debugLineNum = 484;BA.debugLine="blnAppStopQuit = True";
Debug.ShouldStop(8);
__ref.setField ("_blnappstopquit" /*RemoteObject*/ ,b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 485;BA.debugLine="B4XPages.GetNativeParent(Me).Resizable = True";
Debug.ShouldStop(16);
b4xmainpage._b4xpages.runMethod(false,"_getnativeparent" /*RemoteObject*/ ,(Object)(__ref)).runMethod(true,"setResizable",b4xmainpage.__c.getField(true,"True"));
 BA.debugLineNum = 486;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _handlemessage(RemoteObject __ref,RemoteObject _msg,RemoteObject _buffer) throws Exception{
try {
		Debug.PushSubsStack("HandleMessage (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,125);
if (RapidSub.canDelegate("handlemessage")) { __ref.runUserSub(false, "b4xmainpage","handlemessage", __ref, _msg, _buffer); return;}
ResumableSub_HandleMessage rsub = new ResumableSub_HandleMessage(null,__ref,_msg,_buffer);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_HandleMessage extends BA.ResumableSub {
public ResumableSub_HandleMessage(b4j.example.b4xmainpage parent,RemoteObject __ref,RemoteObject _msg,RemoteObject _buffer) {
this.parent = parent;
this.__ref = __ref;
this._msg = _msg;
this._buffer = _buffer;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4j.example.b4xmainpage parent;
RemoteObject _msg;
RemoteObject _buffer;
int _x = 0;
int step26;
int limit26;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("HandleMessage (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,125);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
Debug.locals.put("msg", _msg);
Debug.locals.put("buffer", _buffer);
 BA.debugLineNum = 128;BA.debugLine="If blnVerifyRequest = False Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnverifyrequest" /*RemoteObject*/ ),parent.__c.getField(true,"False"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 129;BA.debugLine="LogMessage(\"PIC16F88\", msg)";
Debug.ShouldStop(1);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("PIC16F88")),(Object)(_msg));
 if (true) break;
;
 BA.debugLineNum = 132;BA.debugLine="Select Case msg";
Debug.ShouldStop(8);

case 4:
//select
this.state = 31;
switch (BA.switchObjectToInt(_msg,BA.ObjectToString("<InitReceived>"),BA.ObjectToString("<ErrorTimeout>"),BA.ObjectToString("<HandShakeTimeout>"),BA.ObjectToString("<StartVerifyFlash>"),BA.ObjectToString("<EndVerifyFlash>"),BA.ObjectToString("<EndFlashErase>"))) {
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
 BA.debugLineNum = 135;BA.debugLine="bln16F88HandShakeSuccess = True";
Debug.ShouldStop(64);
__ref.setField ("_bln16f88handshakesuccess" /*RemoteObject*/ ,parent.__c.getField(true,"True"));
 BA.debugLineNum = 136;BA.debugLine="LogMessage(\"Status\", \"PIC responded! Done sendi";
Debug.ShouldStop(128);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("PIC responded! Done sending 0x55 0xAA")));
 if (true) break;

case 8:
//C
this.state = 31;
 BA.debugLineNum = 140;BA.debugLine="bln16F88ExitTimeoutError = True";
Debug.ShouldStop(2048);
__ref.setField ("_bln16f88exittimeouterror" /*RemoteObject*/ ,parent.__c.getField(true,"True"));
 BA.debugLineNum = 141;BA.debugLine="EnableButtons";
Debug.ShouldStop(4096);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_enablebuttons" /*RemoteObject*/ );
 BA.debugLineNum = 142;BA.debugLine="LogMessage(\"Status\", \"PIC reported timeout erro";
Debug.ShouldStop(8192);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("PIC reported timeout error, try again")));
 if (true) break;

case 10:
//C
this.state = 31;
 BA.debugLineNum = 146;BA.debugLine="LogMessage(\"Status\", \"Timeout exiting bootloade";
Debug.ShouldStop(131072);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Timeout exiting bootloader --> entering application.")));
 if (true) break;

case 12:
//C
this.state = 31;
 BA.debugLineNum = 150;BA.debugLine="cntVerify = 0";
Debug.ShouldStop(2097152);
__ref.setField ("_cntverify" /*RemoteObject*/ ,BA.numberCast(int.class, 0));
 BA.debugLineNum = 151;BA.debugLine="blnVerifyRequest = True";
Debug.ShouldStop(4194304);
__ref.setField ("_blnverifyrequest" /*RemoteObject*/ ,parent.__c.getField(true,"True"));
 BA.debugLineNum = 152;BA.debugLine="LogMessage(\"Status\", \"Waiting for Verification.";
Debug.ShouldStop(8388608);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Waiting for Verification...")));
 if (true) break;

case 14:
//C
this.state = 31;
 BA.debugLineNum = 156;BA.debugLine="EnableButtons";
Debug.ShouldStop(134217728);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_enablebuttons" /*RemoteObject*/ );
 BA.debugLineNum = 157;BA.debugLine="VerifyStatus";
Debug.ShouldStop(268435456);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_verifystatus" /*RemoteObject*/ );
 if (true) break;

case 16:
//C
this.state = 31;
 BA.debugLineNum = 161;BA.debugLine="Sleep(200)";
Debug.ShouldStop(1);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xmainpage", "handlemessage"),BA.numberCast(int.class, 200));
this.state = 32;
return;
case 32:
//C
this.state = 31;
;
 BA.debugLineNum = 162;BA.debugLine="SendFirmware";
Debug.ShouldStop(2);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_sendfirmware" /*void*/ );
 if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 166;BA.debugLine="If blnVerifyRequest = True Then";
Debug.ShouldStop(32);
if (true) break;

case 19:
//if
this.state = 30;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnverifyrequest" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 169;BA.debugLine="For x = 0 To buffer.Length - 1 - 1	' last buff";
Debug.ShouldStop(256);
if (true) break;

case 22:
//for
this.state = 29;
step26 = 1;
limit26 = RemoteObject.solve(new RemoteObject[] {_buffer.getField(true,"length"),RemoteObject.createImmutable(1),RemoteObject.createImmutable(1)}, "--",2, 1).<Integer>get().intValue();
_x = 0 ;
Debug.locals.put("x", _x);
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
Debug.locals.put("x", _x);
if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 171;BA.debugLine="firmwareVerify(cntVerify) = buffer(x)";
Debug.ShouldStop(1024);
__ref.getField(false,"_firmwareverify" /*RemoteObject*/ ).setArrayElement (_buffer.getArrayElement(true,BA.numberCast(int.class, _x)),__ref.getField(true,"_cntverify" /*RemoteObject*/ ));
 BA.debugLineNum = 174;BA.debugLine="prgBar.Progress = Min(1, cntVerify / EXPECTED";
Debug.ShouldStop(8192);
__ref.getField(false,"_prgbar" /*RemoteObject*/ ).runMethod(true,"setProgress",parent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cntverify" /*RemoteObject*/ ),__ref.getField(true,"_expected_firmware_bytes" /*RemoteObject*/ )}, "/",0, 0))));
 BA.debugLineNum = 175;BA.debugLine="cntVerify = cntVerify + 1";
Debug.ShouldStop(16384);
__ref.setField ("_cntverify" /*RemoteObject*/ ,RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_cntverify" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "+",1, 1));
 BA.debugLineNum = 178;BA.debugLine="If cntVerify >= EXPECTED_FIRMWARE_BYTES Then";
Debug.ShouldStop(131072);
if (true) break;

case 25:
//if
this.state = 28;
if (RemoteObject.solveBoolean("g",__ref.getField(true,"_cntverify" /*RemoteObject*/ ),BA.numberCast(double.class, __ref.getField(true,"_expected_firmware_bytes" /*RemoteObject*/ )))) { 
this.state = 27;
}if (true) break;

case 27:
//C
this.state = 28;
 BA.debugLineNum = 181;BA.debugLine="EnableButtons";
Debug.ShouldStop(1048576);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_enablebuttons" /*RemoteObject*/ );
 BA.debugLineNum = 182;BA.debugLine="Exit";
Debug.ShouldStop(2097152);
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
Debug.locals.put("x", _x);
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
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _initialize(RemoteObject __ref,RemoteObject _ba) throws Exception{
try {
		Debug.PushSubsStack("Initialize (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,49);
if (RapidSub.canDelegate("initialize")) { return __ref.runUserSub(false, "b4xmainpage","initialize", __ref, _ba);}
__ref.runVoidMethodAndSync("innerInitializeHelper", _ba);
Debug.locals.put("ba", _ba);
 BA.debugLineNum = 49;BA.debugLine="Public Sub Initialize";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="serial1.Initialize(\"serial\")";
Debug.ShouldStop(131072);
__ref.getField(false,"_serial1" /*RemoteObject*/ ).runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("serial")));
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _logmessage(RemoteObject __ref,RemoteObject _from,RemoteObject _msg) throws Exception{
try {
		Debug.PushSubsStack("LogMessage (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,488);
if (RapidSub.canDelegate("logmessage")) { return __ref.runUserSub(false, "b4xmainpage","logmessage", __ref, _from, _msg);}
Debug.locals.put("From", _from);
Debug.locals.put("Msg", _msg);
 BA.debugLineNum = 488;BA.debugLine="Sub LogMessage(From As String, Msg As String)";
Debug.ShouldStop(128);
 BA.debugLineNum = 494;BA.debugLine="txtLog.Text = txtLog.Text & From & \": \" & Msg & C";
Debug.ShouldStop(8192);
__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runMethod(true,"setText",RemoteObject.concat(__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runMethod(true,"getText"),_from,RemoteObject.createImmutable(": "),_msg,b4xmainpage.__c.getField(true,"CRLF")));
 BA.debugLineNum = 495;BA.debugLine="txtLog.SetSelection(txtLog.Text.Length, txtLog.Te";
Debug.ShouldStop(16384);
__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runVoidMethod ("SetSelection",(Object)(__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runMethod(true,"getText").runMethod(true,"length")),(Object)(__ref.getField(false,"_txtlog" /*RemoteObject*/ ).runMethod(true,"getText").runMethod(true,"length")));
 BA.debugLineNum = 496;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _openfiledialog(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("openFileDialog (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,240);
if (RapidSub.canDelegate("openfiledialog")) { return __ref.runUserSub(false, "b4xmainpage","openfiledialog", __ref);}
RemoteObject _filechooser = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _result = RemoteObject.createImmutable(0);
RemoteObject _selectedfile = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _filepath = RemoteObject.createImmutable("");
RemoteObject _filename = RemoteObject.createImmutable("");
 BA.debugLineNum = 240;BA.debugLine="Private Sub openFileDialog";
Debug.ShouldStop(32768);
 BA.debugLineNum = 241;BA.debugLine="Dim fileChooser As JavaObject";
Debug.ShouldStop(65536);
_filechooser = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("fileChooser", _filechooser);
 BA.debugLineNum = 242;BA.debugLine="fileChooser.InitializeNewInstance(\"javax.swing.JF";
Debug.ShouldStop(131072);
_filechooser.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("javax.swing.JFileChooser")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {b4xmainpage.__c.getField(false,"Null")})));
 BA.debugLineNum = 243;BA.debugLine="Dim result As Int = fileChooser.RunMethod(\"showOp";
Debug.ShouldStop(262144);
_result = BA.numberCast(int.class, _filechooser.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("showOpenDialog")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(__ref.getField(false,"_jframe" /*RemoteObject*/ ).getObject())}))));Debug.locals.put("result", _result);Debug.locals.put("result", _result);
 BA.debugLineNum = 244;BA.debugLine="If result = fileChooser.GetField(\"APPROVE_OPTION\"";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",_result,BA.numberCast(double.class, _filechooser.runMethod(false,"GetField",(Object)(RemoteObject.createImmutable("APPROVE_OPTION")))))) { 
 BA.debugLineNum = 245;BA.debugLine="Dim selectedFile As JavaObject = fileChooser.Run";
Debug.ShouldStop(1048576);
_selectedfile = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_selectedfile = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _filechooser.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSelectedFile")),(Object)((b4xmainpage.__c.getField(false,"Null")))));Debug.locals.put("selectedFile", _selectedfile);Debug.locals.put("selectedFile", _selectedfile);
 BA.debugLineNum = 246;BA.debugLine="Dim filePath As String = selectedFile.RunMethod(";
Debug.ShouldStop(2097152);
_filepath = BA.ObjectToString(_selectedfile.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getPath")),(Object)((b4xmainpage.__c.getField(false,"Null")))));Debug.locals.put("filePath", _filepath);Debug.locals.put("filePath", _filepath);
 BA.debugLineNum = 247;BA.debugLine="LogMessage(\"Status\", \"Selected file Path: \" & fi";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Selected file Path: "),_filepath)));
 BA.debugLineNum = 248;BA.debugLine="Dim FileName As String = fileChooser.RunMethodJO";
Debug.ShouldStop(8388608);
_filename = BA.ObjectToString(_filechooser.runMethod(false,"RunMethodJO",(Object)(BA.ObjectToString("getSelectedFile")),(Object)((b4xmainpage.__c.getField(false,"Null")))).runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getName")),(Object)((b4xmainpage.__c.getField(false,"Null")))));Debug.locals.put("FileName", _filename);Debug.locals.put("FileName", _filename);
 BA.debugLineNum = 249;BA.debugLine="LogMessage(\"Status\", $\"Selected file name: ${Fil";
Debug.ShouldStop(16777216);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)((RemoteObject.concat(RemoteObject.createImmutable("Selected file name: "),b4xmainpage.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_filename))),RemoteObject.createImmutable("")))));
 BA.debugLineNum = 251;BA.debugLine="firmware = ConvertHexIntelToBinaryRange(filePath";
Debug.ShouldStop(67108864);
__ref.setField ("_firmware" /*RemoteObject*/ ,__ref.runClassMethod (b4j.example.b4xmainpage.class, "_converthexinteltobinaryrange" /*RemoteObject*/ ,(Object)(_filepath),(Object)(__ref.getField(true,"_start_addr_flash" /*RemoteObject*/ ))));
 }else {
 BA.debugLineNum = 253;BA.debugLine="LogMessage(\"Status\", \"No file selected.\")";
Debug.ShouldStop(268435456);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("No file selected.")));
 };
 BA.debugLineNum = 257;BA.debugLine="If jframe.IsInitialized Then";
Debug.ShouldStop(1);
if (__ref.getField(false,"_jframe" /*RemoteObject*/ ).runMethod(true,"IsInitialized").<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 258;BA.debugLine="jframe.RunMethod(\"dispose\", Null)";
Debug.ShouldStop(2);
__ref.getField(false,"_jframe" /*RemoteObject*/ ).runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("dispose")),(Object)((b4xmainpage.__c.getField(false,"Null"))));
 };
 BA.debugLineNum = 260;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _sendfirmware(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("SendFirmware (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,381);
if (RapidSub.canDelegate("sendfirmware")) { __ref.runUserSub(false, "b4xmainpage","sendfirmware", __ref); return;}
ResumableSub_SendFirmware rsub = new ResumableSub_SendFirmware(null,__ref);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_SendFirmware extends BA.ResumableSub {
public ResumableSub_SendFirmware(b4j.example.b4xmainpage parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4j.example.b4xmainpage parent;
RemoteObject _totalblocks = RemoteObject.createImmutable(0);
RemoteObject _block = null;
int _i = 0;
RemoteObject _remaining = RemoteObject.createImmutable(0);
RemoteObject _currentblocksize = RemoteObject.createImmutable(0);
int _j = 0;
int _x = 0;
RemoteObject _b = null;
int step4;
int limit4;
int step7;
int limit7;
int step23;
int limit23;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("SendFirmware (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,381);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 384;BA.debugLine="Dim totalBlocks As Int = Ceil(firmware.Length / B";
Debug.ShouldStop(-2147483648);
_totalblocks = BA.numberCast(int.class, parent.__c.runMethod(true,"Ceil",(Object)(RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),__ref.getField(true,"_block_size" /*RemoteObject*/ )}, "/",0, 0))));Debug.locals.put("totalBlocks", _totalblocks);Debug.locals.put("totalBlocks", _totalblocks);
 BA.debugLineNum = 385;BA.debugLine="Dim block(BLOCK_SIZE) As Byte";
Debug.ShouldStop(1);
_block = RemoteObject.createNewArray ("byte", new int[] {__ref.getField(true,"_block_size" /*RemoteObject*/ ).<Integer>get().intValue()}, new Object[]{});Debug.locals.put("block", _block);
 BA.debugLineNum = 387;BA.debugLine="LogMessage(\"FirmwareUpload\", \"Firmware size: \" &";
Debug.ShouldStop(4);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("FirmwareUpload")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Firmware size: "),__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(" bytes, total blocks: "),_totalblocks)));
 BA.debugLineNum = 389;BA.debugLine="For i = 0 To firmware.Length - 1 Step BLOCK_SIZE";
Debug.ShouldStop(16);
if (true) break;

case 1:
//for
this.state = 26;
step4 = __ref.getField(true,"_block_size" /*RemoteObject*/ ).<Integer>get().intValue();
limit4 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
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
Debug.locals.put("i", _i);
if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 392;BA.debugLine="Dim remaining As Int = firmware.Length - i";
Debug.ShouldStop(128);
_remaining = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(_i)}, "-",1, 1);Debug.locals.put("remaining", _remaining);Debug.locals.put("remaining", _remaining);
 BA.debugLineNum = 393;BA.debugLine="Dim currentBlockSize As Int = Min(BLOCK_SIZE, re";
Debug.ShouldStop(256);
_currentblocksize = BA.numberCast(int.class, parent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, __ref.getField(true,"_block_size" /*RemoteObject*/ ))),(Object)(BA.numberCast(double.class, _remaining))));Debug.locals.put("currentBlockSize", _currentblocksize);Debug.locals.put("currentBlockSize", _currentblocksize);
 BA.debugLineNum = 395;BA.debugLine="For j = 0 To BLOCK_SIZE - 1";
Debug.ShouldStop(1024);
if (true) break;

case 4:
//for
this.state = 13;
step7 = 1;
limit7 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_block_size" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_j = 0 ;
Debug.locals.put("j", _j);
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
Debug.locals.put("j", _j);
if (true) break;

case 6:
//C
this.state = 7;
 BA.debugLineNum = 396;BA.debugLine="If j < currentBlockSize Then";
Debug.ShouldStop(2048);
if (true) break;

case 7:
//if
this.state = 12;
if (RemoteObject.solveBoolean("<",RemoteObject.createImmutable(_j),BA.numberCast(double.class, _currentblocksize))) { 
this.state = 9;
}else {
this.state = 11;
}if (true) break;

case 9:
//C
this.state = 12;
 BA.debugLineNum = 398;BA.debugLine="block(j) = firmware(i + j)";
Debug.ShouldStop(8192);
_block.setArrayElement (__ref.getField(false,"_firmware" /*RemoteObject*/ ).getArrayElement(true,RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),RemoteObject.createImmutable(_j)}, "+",1, 1)),BA.numberCast(int.class, _j));
 if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 401;BA.debugLine="block(j) = 0xFF	' Pic 16F88 MSB is 0x3F but 0x";
Debug.ShouldStop(65536);
_block.setArrayElement (BA.numberCast(byte.class, ((int)0xff)),BA.numberCast(int.class, _j));
 if (true) break;

case 12:
//C
this.state = 30;
;
 if (true) break;
if (true) break;
Debug.locals.put("j", _j);
;
 BA.debugLineNum = 406;BA.debugLine="If bln16F88ExitTimeoutError = True Then";
Debug.ShouldStop(2097152);

case 13:
//if
this.state = 16;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_bln16f88exittimeouterror" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 15;
}if (true) break;

case 15:
//C
this.state = 16;
 BA.debugLineNum = 407;BA.debugLine="Return";
Debug.ShouldStop(4194304);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 411;BA.debugLine="If blnAppExitAstreamError = True Then";
Debug.ShouldStop(67108864);

case 16:
//if
this.state = 19;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnappexitastreamerror" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 18;
}if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 412;BA.debugLine="Return";
Debug.ShouldStop(134217728);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 416;BA.debugLine="If blnAppStopQuit = True Then";
Debug.ShouldStop(-2147483648);

case 19:
//if
this.state = 22;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnappstopquit" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 21;
}if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 417;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 421;BA.debugLine="For x = 0 To BLOCK_SIZE - 1";
Debug.ShouldStop(16);

case 22:
//for
this.state = 25;
step23 = 1;
limit23 = RemoteObject.solve(new RemoteObject[] {__ref.getField(true,"_block_size" /*RemoteObject*/ ),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_x = 0 ;
Debug.locals.put("x", _x);
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
Debug.locals.put("x", _x);
if (true) break;

case 24:
//C
this.state = 32;
 BA.debugLineNum = 422;BA.debugLine="Dim b(1) As Byte       				' single-byte array";
Debug.ShouldStop(32);
_b = RemoteObject.createNewArray ("byte", new int[] {1}, new Object[]{});Debug.locals.put("b", _b);
 BA.debugLineNum = 423;BA.debugLine="b(0) = block(x)        				' copy current byte";
Debug.ShouldStop(64);
_b.setArrayElement (_block.getArrayElement(true,BA.numberCast(int.class, _x)),BA.numberCast(int.class, 0));
 BA.debugLineNum = 424;BA.debugLine="astream.Write(b)       				' send the byte";
Debug.ShouldStop(128);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_b));
 BA.debugLineNum = 425;BA.debugLine="Sleep(PACKET_DELAY_MS) 			   	' small delay bet";
Debug.ShouldStop(256);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xmainpage", "sendfirmware"),__ref.getField(true,"_packet_delay_ms" /*RemoteObject*/ ));
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
Debug.locals.put("x", _x);
;
 BA.debugLineNum = 429;BA.debugLine="prgBar.Progress = Min(1, (i + BLOCK_SIZE) / firm";
Debug.ShouldStop(4096);
__ref.getField(false,"_prgbar" /*RemoteObject*/ ).runMethod(true,"setProgress",parent.__c.runMethod(true,"Min",(Object)(BA.numberCast(double.class, 1)),(Object)(RemoteObject.solve(new RemoteObject[] {(RemoteObject.solve(new RemoteObject[] {RemoteObject.createImmutable(_i),__ref.getField(true,"_block_size" /*RemoteObject*/ )}, "+",1, 1)),__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length")}, "/",0, 0))));
 if (true) break;
if (true) break;

case 26:
//C
this.state = -1;
Debug.locals.put("i", _i);
;
 BA.debugLineNum = 432;BA.debugLine="LogMessage(\"FirmwareUpload\", \"Firmware upload com";
Debug.ShouldStop(32768);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("FirmwareUpload")),(Object)(RemoteObject.createImmutable("Firmware upload complete!")));
 BA.debugLineNum = 435;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static void  _sendhandshakeloop(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("SendHandshakeLoop (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,337);
if (RapidSub.canDelegate("sendhandshakeloop")) { __ref.runUserSub(false, "b4xmainpage","sendhandshakeloop", __ref); return;}
ResumableSub_SendHandshakeLoop rsub = new ResumableSub_SendHandshakeLoop(null,__ref);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_SendHandshakeLoop extends BA.ResumableSub {
public ResumableSub_SendHandshakeLoop(b4j.example.b4xmainpage parent,RemoteObject __ref) {
this.parent = parent;
this.__ref = __ref;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
RemoteObject __ref;
b4j.example.b4xmainpage parent;
RemoteObject _b = null;
RemoteObject _b2 = null;
RemoteObject _xtract = RemoteObject.createImmutable(0);

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("SendHandshakeLoop (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,337);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
Debug.locals.put("_ref", __ref);
 BA.debugLineNum = 339;BA.debugLine="If astream.IsInitialized = False Then";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 4;
if (RemoteObject.solveBoolean("=",__ref.getField(false,"_astream" /*RemoteObject*/ ).runMethod(true,"IsInitialized"),parent.__c.getField(true,"False"))) { 
this.state = 3;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 340;BA.debugLine="LogMessage(\"Handshake\", \"Error Astream not initi";
Debug.ShouldStop(524288);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Handshake")),(Object)(RemoteObject.createImmutable("Error Astream not initialized")));
 BA.debugLineNum = 341;BA.debugLine="Return";
Debug.ShouldStop(1048576);
if (true) return ;
 if (true) break;

case 4:
//C
this.state = 5;
;
 BA.debugLineNum = 344;BA.debugLine="Dim b() As Byte = Array As Byte(0x55)";
Debug.ShouldStop(8388608);
_b = RemoteObject.createNewArray("byte",new int[] {1},new Object[] {BA.numberCast(byte.class, ((int)0x55))});Debug.locals.put("b", _b);Debug.locals.put("b", _b);
 BA.debugLineNum = 345;BA.debugLine="Dim b2() As Byte = Array As Byte(0xAA)";
Debug.ShouldStop(16777216);
_b2 = RemoteObject.createNewArray("byte",new int[] {1},new Object[] {BA.numberCast(byte.class, ((int)0xaa))});Debug.locals.put("b2", _b2);Debug.locals.put("b2", _b2);
 BA.debugLineNum = 346;BA.debugLine="Dim xTract As Int = 0";
Debug.ShouldStop(33554432);
_xtract = BA.numberCast(int.class, 0);Debug.locals.put("xTract", _xtract);Debug.locals.put("xTract", _xtract);
 BA.debugLineNum = 348;BA.debugLine="DisableButtons";
Debug.ShouldStop(134217728);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_disablebuttons" /*RemoteObject*/ );
 BA.debugLineNum = 350;BA.debugLine="Do While True";
Debug.ShouldStop(536870912);
if (true) break;

case 5:
//do while
this.state = 32;
while (parent.__c.getField(true,"True").<Boolean>get().booleanValue()) {
this.state = 7;
if (true) break;
}
if (true) break;

case 7:
//C
this.state = 8;
 BA.debugLineNum = 352;BA.debugLine="If blnAppExitAstreamError = True Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 8:
//if
this.state = 11;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnappexitastreamerror" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 10;
}if (true) break;

case 10:
//C
this.state = 11;
 BA.debugLineNum = 353;BA.debugLine="Return";
Debug.ShouldStop(1);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 357;BA.debugLine="If blnAppStopQuit = True Then";
Debug.ShouldStop(16);

case 11:
//if
this.state = 14;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_blnappstopquit" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 13;
}if (true) break;

case 13:
//C
this.state = 14;
 BA.debugLineNum = 358;BA.debugLine="Return";
Debug.ShouldStop(32);
if (true) return ;
 if (true) break;
;
 BA.debugLineNum = 362;BA.debugLine="If bln16F88HandShakeSuccess = True Then";
Debug.ShouldStop(512);

case 14:
//if
this.state = 25;
if (RemoteObject.solveBoolean("=",__ref.getField(true,"_bln16f88handshakesuccess" /*RemoteObject*/ ),parent.__c.getField(true,"True"))) { 
this.state = 16;
}else {
this.state = 18;
}if (true) break;

case 16:
//C
this.state = 25;
 BA.debugLineNum = 363;BA.debugLine="Return";
Debug.ShouldStop(1024);
if (true) return ;
 if (true) break;

case 18:
//C
this.state = 19;
 BA.debugLineNum = 365;BA.debugLine="If xTract = 0 Then";
Debug.ShouldStop(4096);
if (true) break;

case 19:
//if
this.state = 24;
if (RemoteObject.solveBoolean("=",_xtract,BA.numberCast(double.class, 0))) { 
this.state = 21;
}else {
this.state = 23;
}if (true) break;

case 21:
//C
this.state = 24;
 BA.debugLineNum = 366;BA.debugLine="astream.Write(b)";
Debug.ShouldStop(8192);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_b));
 BA.debugLineNum = 367;BA.debugLine="LogMessage(\"SendHandshakeLoop\", \"55\")";
Debug.ShouldStop(16384);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("SendHandshakeLoop")),(Object)(RemoteObject.createImmutable("55")));
 if (true) break;

case 23:
//C
this.state = 24;
 BA.debugLineNum = 369;BA.debugLine="astream.Write(b2)";
Debug.ShouldStop(65536);
__ref.getField(false,"_astream" /*RemoteObject*/ ).runVoidMethod ("Write",(Object)(_b2));
 BA.debugLineNum = 370;BA.debugLine="LogMessage(\"SendHandshakeLoop\", \"AA\")";
Debug.ShouldStop(131072);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("SendHandshakeLoop")),(Object)(RemoteObject.createImmutable("AA")));
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
 BA.debugLineNum = 375;BA.debugLine="Sleep(HANDSHAKE_DELAY_MS)";
Debug.ShouldStop(4194304);
parent.__c.runVoidMethod ("Sleep",__ref.getField(false, "ba"),anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "b4xmainpage", "sendhandshakeloop"),__ref.getField(true,"_handshake_delay_ms" /*RemoteObject*/ ));
this.state = 33;
return;
case 33:
//C
this.state = 26;
;
 BA.debugLineNum = 377;BA.debugLine="xTract = xTract + 1";
Debug.ShouldStop(16777216);
_xtract = RemoteObject.solve(new RemoteObject[] {_xtract,RemoteObject.createImmutable(1)}, "+",1, 1);Debug.locals.put("xTract", _xtract);
 BA.debugLineNum = 378;BA.debugLine="If xTract >= 2 Then xTract = 0";
Debug.ShouldStop(33554432);
if (true) break;

case 26:
//if
this.state = 31;
if (RemoteObject.solveBoolean("g",_xtract,BA.numberCast(double.class, 2))) { 
this.state = 28;
;}if (true) break;

case 28:
//C
this.state = 31;
_xtract = BA.numberCast(int.class, 0);Debug.locals.put("xTract", _xtract);
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
 BA.debugLineNum = 380;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
if (true) break;

            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _verifyfirmware(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("VerifyFirmware (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,444);
if (RapidSub.canDelegate("verifyfirmware")) { return __ref.runUserSub(false, "b4xmainpage","verifyfirmware", __ref);}
int _i = 0;
 BA.debugLineNum = 444;BA.debugLine="Sub VerifyFirmware() As Boolean";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 446;BA.debugLine="If firmware.Length <> firmwareVerify.Length Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),BA.numberCast(double.class, __ref.getField(false,"_firmwareverify" /*RemoteObject*/ ).getField(true,"length")))) { 
 BA.debugLineNum = 447;BA.debugLine="Return False";
Debug.ShouldStop(1073741824);
if (true) return b4xmainpage.__c.getField(true,"False");
 };
 BA.debugLineNum = 451;BA.debugLine="For i = 0 To firmware.Length - 1";
Debug.ShouldStop(4);
{
final int step4 = 1;
final int limit4 = RemoteObject.solve(new RemoteObject[] {__ref.getField(false,"_firmware" /*RemoteObject*/ ).getField(true,"length"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
for (;(step4 > 0 && _i <= limit4) || (step4 < 0 && _i >= limit4) ;_i = ((int)(0 + _i + step4))  ) {
Debug.locals.put("i", _i);
 BA.debugLineNum = 452;BA.debugLine="If firmware(i) <> firmwareVerify(i) Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("!",__ref.getField(false,"_firmware" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)),BA.numberCast(double.class, __ref.getField(false,"_firmwareverify" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i))))) { 
 BA.debugLineNum = 453;BA.debugLine="LogMessage(\"Status\", \"Mismatch at byte \" & i &";
Debug.ShouldStop(16);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.concat(RemoteObject.createImmutable("Mismatch at byte "),RemoteObject.createImmutable(_i),RemoteObject.createImmutable(": firmware = "),__ref.runClassMethod (b4j.example.b4xmainpage.class, "_bytestohexstring2" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_firmware" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)))),RemoteObject.createImmutable(" vs verify = "),__ref.runClassMethod (b4j.example.b4xmainpage.class, "_bytestohexstring2" /*RemoteObject*/ ,(Object)(__ref.getField(false,"_firmwareverify" /*RemoteObject*/ ).getArrayElement(true,BA.numberCast(int.class, _i)))))));
 BA.debugLineNum = 456;BA.debugLine="Return False";
Debug.ShouldStop(128);
if (true) return b4xmainpage.__c.getField(true,"False");
 };
 }
}Debug.locals.put("i", _i);
;
 BA.debugLineNum = 461;BA.debugLine="Return True";
Debug.ShouldStop(4096);
if (true) return b4xmainpage.__c.getField(true,"True");
 BA.debugLineNum = 462;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable(false);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _verifystatus(RemoteObject __ref) throws Exception{
try {
		Debug.PushSubsStack("VerifyStatus (b4xmainpage) ","b4xmainpage",1,__ref.getField(false, "ba"),__ref,437);
if (RapidSub.canDelegate("verifystatus")) { return __ref.runUserSub(false, "b4xmainpage","verifystatus", __ref);}
 BA.debugLineNum = 437;BA.debugLine="Sub VerifyStatus";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 438;BA.debugLine="If VerifyFirmware = True Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("=",__ref.runClassMethod (b4j.example.b4xmainpage.class, "_verifyfirmware" /*RemoteObject*/ ),b4xmainpage.__c.getField(true,"True"))) { 
 BA.debugLineNum = 439;BA.debugLine="LogMessage(\"Status\", \"Programming/Verify Success";
Debug.ShouldStop(4194304);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Programming/Verify Success")));
 }else {
 BA.debugLineNum = 441;BA.debugLine="LogMessage(\"Status\", \"Programming/Verify Failed!";
Debug.ShouldStop(16777216);
__ref.runClassMethod (b4j.example.b4xmainpage.class, "_logmessage" /*RemoteObject*/ ,(Object)(BA.ObjectToString("Status")),(Object)(RemoteObject.createImmutable("Programming/Verify Failed!")));
 };
 BA.debugLineNum = 443;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}