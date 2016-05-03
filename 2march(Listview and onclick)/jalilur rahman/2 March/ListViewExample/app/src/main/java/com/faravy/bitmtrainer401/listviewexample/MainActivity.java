package com.faravy.bitmtrainer401.listviewexample;

import android.app.LauncherActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        final String [] studentList={"Nazmul","Raju","Sumi","Sudarshon","Azhar","Tohid","Robi","Airtel","Gp","Teletalk","Banglalink","Arif","Zakaria","Masud"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.row_view,studentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedItem=studentList[position];
                Toast.makeText(MainActivity.this, clickedItem+" Position= "+position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
