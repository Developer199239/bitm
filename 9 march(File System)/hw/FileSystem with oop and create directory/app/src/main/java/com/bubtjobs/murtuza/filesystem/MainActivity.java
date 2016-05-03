package com.bubtjobs.murtuza.filesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    TextView outputTv;
    EditText inputEt;
    CreateDirectory createDirectory;
    ReadWrite readWrite;
    boolean isDirectoryCreate;
    boolean isWrite;
    String directory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initalize();

    }

    public void initalize() {

        outputTv = (TextView) findViewById(R.id.outputTv);
        inputEt = (EditText) findViewById(R.id.inputEt);

        createDirectory = new CreateDirectory();
        readWrite = new ReadWrite();

        directory = createDirectory.create();
        if (directory.length() == 1) {
            isDirectoryCreate = false;
            Toast.makeText(MainActivity.this, "File is not created", Toast.LENGTH_SHORT).show();
        } else {
            isDirectoryCreate = true;
            Toast.makeText(MainActivity.this, "File is created", Toast.LENGTH_SHORT).show();
        }
    }

    public void save(View view) {

        if (isDirectoryCreate) {
            isWrite = readWrite.write(directory, inputEt.getText().toString());
            inputEt.getText().clear();
            if (isWrite)
                Toast.makeText(MainActivity.this, "Write complete", Toast.LENGTH_SHORT).show();

            else
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, "Please Create Directory", Toast.LENGTH_SHORT).show();
    }

    public void retrive(View view) {
        if (isDirectoryCreate)
            outputTv.setText(readWrite.read(directory));
        else
            Toast.makeText(MainActivity.this, "Please Create Directory", Toast.LENGTH_SHORT).show();

    }
}
