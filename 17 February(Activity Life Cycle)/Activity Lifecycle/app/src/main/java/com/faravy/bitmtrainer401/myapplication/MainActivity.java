package com.faravy.bitmtrainer401.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notifyLifeCycle("onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
        notifyLifeCycle("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notifyLifeCycle("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notifyLifeCycle("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notifyLifeCycle("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notifyLifeCycle("onDestroy");
    }

    private void notifyLifeCycle(String name){

        Notification notification=new Notification.Builder(this)
                .setContentTitle(name)
                .setSmallIcon(R.mipmap.ic_launcher).build();

        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        manager.notify((int) System.currentTimeMillis(),notification);


    }
}
