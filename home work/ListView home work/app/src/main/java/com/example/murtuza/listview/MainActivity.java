package com.example.murtuza.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ListView listView;
    EditText nameEt,phoneEt;
    Button generateBT;
    int imagecount=0;
    ArrayList<Person> personArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        nameEt=(EditText)findViewById(R.id.nameET);
        phoneEt=(EditText)findViewById(R.id.phoneET);
        generateBT=(Button)findViewById(R.id.generateBt);
        personArrayList=new ArrayList<>();


        generateBT.setOnClickListener(this);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,PersonViewDetails.class);
                intent.putExtra("name",personArrayList.get(position).getName());
                intent.putExtra("phone",personArrayList.get(position).getPhone());
                intent.putExtra("image",personArrayList.get(position).getImage());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        String name="",phone="";
        name=nameEt.getText().toString();
        phone=phoneEt.getText().toString();
        nameEt.setText("");
        phoneEt.setText("");
        if(name.length()>0 && phone.length()>0)
        {

            //Person person=new Person(name,phone,"img"+imagecount%4+".jpg");
            Person person=new Person();
            if(imagecount==0)
            person=new Person(name,phone,R.drawable.img1);
            else if(imagecount==1)
                person=new Person(name,phone,R.drawable.img0);
            else if(imagecount==2)
                person=new Person(name,phone,R.drawable.img2);
            personArrayList.add(person);

            imagecount++;
            if(imagecount>=3)
                imagecount=0;
            show();
        }
        else
            Toast.makeText(MainActivity.this,"Insert All Feild",Toast.LENGTH_SHORT).show();
    }

    public void show(){
        if(personArrayList!=null) {
            PersonAdapter personAdapter = new PersonAdapter(getApplicationContext(), personArrayList);
            listView.setAdapter(personAdapter);
        }

    }
}
