package com.example.powerconnected;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MicrophoneReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (Intent.ACTION_HEADSET_PLUG.equals(action)) {
            int iii = intent.getIntExtra("state", -1);
            if (iii == 0) {
                Toast.makeText(context.getApplicationContext(), "Microphone Disconnected", Toast.LENGTH_LONG).show();
            }
            if (iii == 1) {
                Toast.makeText(context.getApplicationContext(), "Microphone Connected",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
