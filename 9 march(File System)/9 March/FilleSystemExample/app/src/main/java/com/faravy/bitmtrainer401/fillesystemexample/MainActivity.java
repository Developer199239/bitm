package com.faravy.bitmtrainer401.fillesystemexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView outPutTv;
    EditText inputEt;
    Button btnSave;
    Button btnRetrieve;

    static final String FILE_NAME = "batch13.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outPutTv = (TextView) findViewById(R.id.textView);
        inputEt = (EditText) findViewById(R.id.editText);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnRetrieve = (Button) findViewById(R.id.btnRetrieve);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textTobeSaved = inputEt.getText().toString();
                writeToFile(textTobeSaved);

            }
        });


        btnRetrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputText = readFromFile();
                outPutTv.setText(outputText);

            }
        });
    }


    private void writeToFile(String text) {

        try {

            OutputStreamWriter writer = new OutputStreamWriter(openFileOutput(FILE_NAME, MODE_PRIVATE));
            writer.write(text);
            writer.close();

        } catch (FileNotFoundException e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

        }

    }

    private String readFromFile() {
        String output = "";

        try {
            InputStream inputStream = openFileInput(FILE_NAME);

            if (inputStream != null) {

                InputStreamReader reader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(reader);

                String receivedText = "";
                StringBuilder builder = new StringBuilder();

                while ((receivedText = bufferedReader.readLine()) != null) {
                    builder.append(receivedText);
                }
                inputStream.close();

                output = builder.toString();
            }


        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

        }
        return output;
    }
}
