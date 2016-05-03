package com.faravy.bitmtrainer401.alarmmanagertest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    AlarmManager mAlarmManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    public void setAlarm(View view) {
        long millis = Long.parseLong(((EditText) findViewById(R.id.etTime))
                .getText().toString());

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
                0, new Intent(getApplicationContext(), MainActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);

//        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),
//                0, new Intent(getApplicationContext(), MainActivity.class),
//                PendingIntent.FLAG_UPDATE_CURRENT);

        mAlarmManager.set(AlarmManager.RTC,
                System.currentTimeMillis() + millis, pendingIntent);
        mAlarmManager.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + millis,
                20000, pendingIntent);
    }
}





