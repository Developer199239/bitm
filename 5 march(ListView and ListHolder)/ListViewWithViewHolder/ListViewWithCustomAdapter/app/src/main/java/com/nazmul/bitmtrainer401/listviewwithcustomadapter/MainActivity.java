package com.nazmul.bitmtrainer401.listviewwithcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView sampleLV;
    ArrayList<PersonModel> personModelArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sampleLV = (ListView) findViewById(R.id.sampleListView);
        personModelArrayList = new ArrayList<>();
        PersonModel personModel = new PersonModel();
        personModel.setName("Akbar");
        personModel.setLocation("Mohammadpur");
        PersonModel personModel2 = new PersonModel();
        personModel2.setName("Saikat");
        personModel2.setLocation("Rampura");
        personModelArrayList.add(personModel);
        personModelArrayList.add(personModel2);
        AdapterForPerson adapter=new AdapterForPerson(getApplicationContext(),personModelArrayList);
        sampleLV.setAdapter(adapter);

    }
}
