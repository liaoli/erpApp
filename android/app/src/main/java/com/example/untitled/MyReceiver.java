package com.example.untitled;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import io.flutter.plugin.common.MethodChannel;


public class MyReceiver extends BroadcastReceiver {

    public static final String ACTION_DECODE = "android.intent.ACTION_DECODE_DATA";
    public static final java.lang.String BARCODE_LENGTH_TAG = "length";
    public static final java.lang.String BARCODE_STRING_TAG = "barcode_string";
    public static final java.lang.String BARCODE_TYPE_TAG = "barcodeType";
    public static final java.lang.String DECODE_DATA_TAG = "barcode";

    @Override
    public void onReceive(Context context, Intent intent) {
        byte[] barcode = intent.getByteArrayExtra(DECODE_DATA_TAG);
        String barcodeString = intent.getStringExtra(BARCODE_STRING_TAG);
        int barcodeLen = intent.getIntExtra(BARCODE_LENGTH_TAG, 0);
        byte type = intent.getByteExtra(BARCODE_TYPE_TAG, (byte) 0);

        invokeFlutterMethod_toAllFlutter(barcodeString);
        Log.i("scanr barcodeString: ",barcodeString);
        Log.i("scanr_barcodeLen",barcodeLen+"");
        Log.i("scanr_type",type+"");
        Log.i("scanr_barcode",barcode+"");
    }


    public void invokeFlutterMethod_toAllFlutter(String code) {
        if (MainActivity.methodChannel_toFlutter != null) {
            MainActivity.methodChannel_toFlutter.invokeMethod("fluMethod", code, new MethodChannel.Result() {
                @Override
                public void success(Object o) {

                }

                @Override
                public void error(String s, String s1, Object o) {
                }

                @Override
                public void notImplemented() {

                }
            });
        }
    }
}
