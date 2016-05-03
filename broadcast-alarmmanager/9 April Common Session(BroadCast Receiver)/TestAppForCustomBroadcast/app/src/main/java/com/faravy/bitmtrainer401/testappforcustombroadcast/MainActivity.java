package com.faravy.bitmtrainer401.testappforcustombroadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendBroadcast(View view) {
        String msg = ((EditText) findViewById(R.id.etMsg)).getText().toString();

        Intent intent = new Intent("CUSTOM_ACTION");
        intent.putExtra("msg", msg);
        sendBroadcast(intent);
    }
}
