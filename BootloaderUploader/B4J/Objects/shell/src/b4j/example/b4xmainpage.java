
package b4j.example;

import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RemoteObject;

public class b4xmainpage {
    public static RemoteObject myClass;
	public b4xmainpage() {
	}
    public static PCBA staticBA = new PCBA(null, b4xmainpage.class);

public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _start_addr_flash = RemoteObject.createImmutable(0);
public static RemoteObject _end_addr_flash = RemoteObject.createImmutable(0);
public static RemoteObject _words_per_packet = RemoteObject.createImmutable(0);
public static RemoteObject _block_size = RemoteObject.createImmutable(0);
public static RemoteObject _packet_delay_ms = RemoteObject.createImmutable(0);
public static RemoteObject _handshake_delay_ms = RemoteObject.createImmutable(0);
public static RemoteObject _msb_word_addr = RemoteObject.createImmutable(0);
public static RemoteObject _expected_firmware_bytes = RemoteObject.createImmutable(0);
public static RemoteObject _serial1 = RemoteObject.declareNull("anywheresoftware.b4j.serial.Serial");
public static RemoteObject _astream = RemoteObject.declareNull("anywheresoftware.b4a.randomaccessfile.AsyncStreams");
public static RemoteObject _jframe = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
public static RemoteObject _root = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper");
public static RemoteObject _xui = RemoteObject.declareNull("anywheresoftware.b4a.objects.B4XViewWrapper.XUI");
public static RemoteObject _btnflash = RemoteObject.declareNull("anywheresoftware.b4j.objects.ButtonWrapper");
public static RemoteObject _btnloadfile = RemoteObject.declareNull("anywheresoftware.b4j.objects.ButtonWrapper");
public static RemoteObject _btnopen = RemoteObject.declareNull("anywheresoftware.b4j.objects.ButtonWrapper");
public static RemoteObject _txtlog = RemoteObject.declareNull("anywheresoftware.b4j.objects.TextInputControlWrapper.TextAreaWrapper");
public static RemoteObject _cmbport = RemoteObject.declareNull("anywheresoftware.b4j.objects.ComboBoxWrapper");
public static RemoteObject _prgbar = RemoteObject.declareNull("anywheresoftware.b4j.objects.ProgressIndicatorWrapper.ProgressBarWrapper");
public static RemoteObject _firmware = null;
public static RemoteObject _firmwareverify = null;
public static RemoteObject _cntverify = RemoteObject.createImmutable(0);
public static RemoteObject _blnverifyrequest = RemoteObject.createImmutable(false);
public static RemoteObject _blnprogramminginprogress = RemoteObject.createImmutable(false);
public static RemoteObject _bln16f88handshakesuccess = RemoteObject.createImmutable(false);
public static RemoteObject _bln16f88exittimeouterror = RemoteObject.createImmutable(false);
public static RemoteObject _blnappexitastreamerror = RemoteObject.createImmutable(false);
public static RemoteObject _blnappstopquit = RemoteObject.createImmutable(false);
public static RemoteObject _rxbufferstring = RemoteObject.createImmutable("");
public static RemoteObject _rxbuffer = null;
public static b4j.example.main _main = null;
public static b4j.example.b4xpages _b4xpages = null;
public static b4j.example.b4xcollections _b4xcollections = null;
public static Object[] GetGlobals(RemoteObject _ref) throws Exception {
		return new Object[] {"astream",_ref.getField(false, "_astream"),"bln16F88ExitTimeoutError",_ref.getField(false, "_bln16f88exittimeouterror"),"bln16F88HandShakeSuccess",_ref.getField(false, "_bln16f88handshakesuccess"),"blnAppExitAstreamError",_ref.getField(false, "_blnappexitastreamerror"),"blnAppStopQuit",_ref.getField(false, "_blnappstopquit"),"blnProgrammingInProgress",_ref.getField(false, "_blnprogramminginprogress"),"blnVerifyRequest",_ref.getField(false, "_blnverifyrequest"),"BLOCK_SIZE",_ref.getField(false, "_block_size"),"btnFlash",_ref.getField(false, "_btnflash"),"btnLoadFile",_ref.getField(false, "_btnloadfile"),"btnOpen",_ref.getField(false, "_btnopen"),"cmbPort",_ref.getField(false, "_cmbport"),"cntVerify",_ref.getField(false, "_cntverify"),"END_ADDR_FLASH",_ref.getField(false, "_end_addr_flash"),"EXPECTED_FIRMWARE_BYTES",_ref.getField(false, "_expected_firmware_bytes"),"firmware",_ref.getField(false, "_firmware"),"firmwareVerify",_ref.getField(false, "_firmwareverify"),"HANDSHAKE_DELAY_MS",_ref.getField(false, "_handshake_delay_ms"),"jframe",_ref.getField(false, "_jframe"),"MSB_WORD_ADDR",_ref.getField(false, "_msb_word_addr"),"PACKET_DELAY_MS",_ref.getField(false, "_packet_delay_ms"),"prgBar",_ref.getField(false, "_prgbar"),"Root",_ref.getField(false, "_root"),"rxBuffer",_ref.getField(false, "_rxbuffer"),"rxBufferString",_ref.getField(false, "_rxbufferstring"),"serial1",_ref.getField(false, "_serial1"),"START_ADDR_FLASH",_ref.getField(false, "_start_addr_flash"),"txtLog",_ref.getField(false, "_txtlog"),"WORDS_PER_PACKET",_ref.getField(false, "_words_per_packet"),"xui",_ref.getField(false, "_xui")};
}
}