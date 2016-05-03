package com.faravy.bitmtrainer401.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nameET;
    EditText phoneNoET;
    private Contact contact;
    private Contact_Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = (EditText) findViewById(R.id.inputName);
        phoneNoET = (EditText) findViewById(R.id.inputPhoneNo);
        manager = new Contact_Manager(this);


    }

    public void saveContact(View view) {
        String name = nameET.getText().toString();
        String phoneno = phoneNoET.getText().toString();
        contact = new Contact(name, phoneno);
        boolean inserted = manager.addContact(contact);
        if (inserted) {
            Toast.makeText(getApplicationContext(), "Insert Successfull", Toast.LENGTH_LONG).show();

        } else Toast.makeText(getApplicationContext(), "Insert Failed", Toast.LENGTH_LONG).show();

    }

    public  void searchContact(View view){

      //  contact=manager.getContact(1);

       //
        //contact=new Contact("Azhar","1234");
       // manager.updateContact(1,contact);
        manager.deleteContact(1);
        ArrayList<Contact> contactList=manager.getAllContacts();
        contact=contactList.get(0);

        Toast.makeText(getApplicationContext(),contact.getName(),Toast.LENGTH_LONG).show();

    }
}
