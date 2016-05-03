package com.faravy.bitmtrainer401.implicitintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText noEditText;
    EditText textEditText;
    Button btnCall;
    Button btnSms;

    String phoneNo;
    String textToBeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noEditText = (EditText) findViewById(R.id.noEditText);
        textEditText = (EditText) findViewById(R.id.smsEditText);

        btnCall = (Button) findViewById(R.id.btnCall);
        btnSms = (Button) findViewById(R.id.btnSms);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                phoneNo = noEditText.getText().toString();
                if (phoneNo.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please Insert A No", Toast.LENGTH_LONG).show();
                } else {

                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + phoneNo));
                    startActivity(callIntent);
                }
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textToBeSent = textEditText.getText().toString();
                phoneNo = noEditText.getText().toString();
                Uri uri = Uri.parse("smsto:" + phoneNo);
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsIntent.putExtra("sms_body", textToBeSent);
                startActivity(smsIntent);

            }
        });

    }
}
