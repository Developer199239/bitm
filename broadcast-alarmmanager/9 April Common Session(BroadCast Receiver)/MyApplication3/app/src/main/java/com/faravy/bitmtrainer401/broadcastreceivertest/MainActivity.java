package com.faravy.bitmtrainer401.broadcastreceivertest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disableComponent();
    }

    private void disableComponent() {
//        ComponentName name = new ComponentName(getApplicationContext(),
//                CustomReceiver.class);
//        getPackageManager().setComponentEnabledSetting(
//                name,
//                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                PackageManager.DONT_KILL_APP
//        );
    }

    public void broadcast(View view) {
        Intent intent = new Intent("CUSTOM_ACTION");
        intent.putExtra("msg", "Hi, there");
        sendBroadcast(intent);
    }
}
