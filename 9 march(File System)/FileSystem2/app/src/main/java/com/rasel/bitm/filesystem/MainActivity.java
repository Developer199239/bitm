package com.rasel.bitm.filesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
    TextView showTv;
    EditText inputEt;

    static final String FILE_NAME="jalilur.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTv=(TextView)findViewById(R.id.viewTv);
        inputEt=(EditText)findViewById(R.id.editTx);
    }
    public void save(View view){
        String input=inputEt.getText().toString();
        writeToFile(input);
    }
    public void retrive(View view){
        String outputText = readFromFile();
        showTv.setText(outputText);

    }

    private void writeToFile(String text){
        try {
            OutputStreamWriter writer=new OutputStreamWriter(openFileOutput(FILE_NAME,MODE_PRIVATE));
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromFile(){
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
