package com.faravy.bitmtrainer401.explicitintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.textView);
        message=getIntent().getStringExtra("message");
        textView.setText(message);

    }
}
