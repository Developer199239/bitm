package com.example.bitmtrainer401.fragmentexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFragment1;
    Button btnFragment2;
    Button btnFragment3;
    Fragment currentFragment;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragment1 = (Button) findViewById(R.id.btn1);
        btnFragment2 = (Button) findViewById(R.id.btn2);
        btnFragment3 = (Button) findViewById(R.id.btn3);

        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);
        btnFragment3.setOnClickListener(this);
        currentFragment=new StartFragment();

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.myFragment, currentFragment);
        transaction.commit();



    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btn1) {
            currentFragment = new Fragment1();

        } else if (id == R.id.btn2) {
            currentFragment = new Fragment2();

        } else if (id == R.id.btn3) {
            currentFragment = new Fragment3();

        }

        transaction = manager.beginTransaction();
        transaction.replace(R.id.myFragment, currentFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
