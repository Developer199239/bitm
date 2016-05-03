package com.faravy.bitmtrainer401.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    EditText dataEditText;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        dataEditText = (EditText) findViewById(R.id.dataEditText);
    }

    public void sendData(View view) {
        text = dataEditText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("message", text);

        startActivity(intent);


    }
}
