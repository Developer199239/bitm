package com.android.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText userEt,passEt;
    TextView userTv,passTv;
    MyShare myShare;

//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEt=(EditText)findViewById(R.id.userEt);
        passEt=(EditText)findViewById(R.id.passEt);
        userTv=(TextView)findViewById(R.id.userTv);
        passTv=(TextView)findViewById(R.id.passTv);


        myShare=new MyShare(MainActivity.this);


//        sharedPreferences=getSharedPreferences("login",0);
//        editor=sharedPreferences.edit();

    }

    public void save(View view){
        if(userEt.getText().toString().length()>0 &&passEt.getText().toString().length()>0 )
        {
            myShare.save(userEt.getText().toString(), passEt.getText().toString());
            userEt.getText().clear();
            passEt.getText().clear();
        }
        else{
            Toast.makeText(MainActivity.this,"Input Empty",Toast.LENGTH_SHORT)  .show();
        }
    }

    public void retrive(View view){
        HashMap<String, String> list=new  HashMap<String, String>();
        list=myShare.retrive();

        String name=list.get("name");
        String pass=list.get("pass");
      userTv.setText(name);
      passTv.setText(pass);

    }

    public void delete(View view){
     myShare.delete();
    }

}
