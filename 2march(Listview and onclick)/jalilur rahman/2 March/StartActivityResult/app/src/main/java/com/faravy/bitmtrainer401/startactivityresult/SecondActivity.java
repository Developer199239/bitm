package com.faravy.bitmtrainer401.startactivityresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by BITM Trainer 401 on 3/2/2016.
 */
public class SecondActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText=(EditText) findViewById(R.id.editText);
    }

    public  void sendResult(View view){

        Intent intent=new Intent();
        intent.putExtra("message",editText.getText().toString());
        setResult(2,intent);
        finish();
    }
}
