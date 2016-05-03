package com.faravy.bitmtrainer401.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class PowerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        String msg = action.equals(Intent.ACTION_POWER_CONNECTED) ? "Power connected" : "Power disconnected";
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
