package com.example.untitled;

import android.os.Bundle;
import android.util.Log;
import android.view.InputDevice;
import android.view.KeyEvent;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {

   static MethodChannel methodChannel_toFlutter;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        methodChannel_toFlutter = new MethodChannel(
                getFlutterEngine().getDartExecutor().getBinaryMessenger(),"toFlutterChannelName"
        );

    }




}


