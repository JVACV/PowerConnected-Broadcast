package com.example.powerconnected;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private BroadcastReceiver broadcastReceiver1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        broadcastReceiver1 = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                final String action = intent.getAction();
//                if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
//                    int iii = intent.getIntExtra("state", -1);
//                    if (iii == 0) {
//                        Microphone_Plugged_in = false;
//                        Toast.makeText(getApplicationContext(), "Microphone Disconnected", Toast.LENGTH_LONG).show();
//                    }
//                    if (iii == 1) {
//                        Microphone_Plugged_in = true;
//                        Toast.makeText(getApplicationContext(), "Microphone Connected",
//                                Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        broadcastReceiver = new PlugInControlReceiver();

        IntentFilter ifilter = new IntentFilter();
        ifilter.addAction(Intent.ACTION_POWER_CONNECTED);
        ifilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        registerReceiver(broadcastReceiver, ifilter);

        broadcastReceiver1 = new MicrophoneReceiver();
        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(broadcastReceiver1, receiverFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
        unregisterReceiver(broadcastReceiver1);
    }
}