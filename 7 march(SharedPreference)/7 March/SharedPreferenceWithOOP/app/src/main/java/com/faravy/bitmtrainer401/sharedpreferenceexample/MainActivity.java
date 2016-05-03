package com.faravy.bitmtrainer401.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showResult;
    EditText inputEt;
    String dataTobeSaved;
    Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showResult = (TextView) findViewById(R.id.showResult);
        inputEt = (EditText) findViewById(R.id.input);
        preference=new Preference(MainActivity.this);



    }

    public void save(View view) {

        dataTobeSaved = inputEt.getText().toString();
        preference.saveUserData(dataTobeSaved);
        inputEt.getText().clear();


    }

    public void retrieve(View view) {

       String name=preference.retrieveUserData();
        showResult.setText(name);
    }

    public void delete(View v) {
       // editor.remove("message");
       // editor.clear();
       // editor.commit();
    }


}
