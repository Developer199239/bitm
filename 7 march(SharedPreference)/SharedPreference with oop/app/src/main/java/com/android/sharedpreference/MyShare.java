package com.android.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mobile App Develop on 7-3-16.
 */
public class MyShare {
   public SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ArrayList<HashMap<String, String>> list;

    public MyShare(Context context){

        sharedPreferences=context.getSharedPreferences("login",context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void save(String name,String pass){
        editor.putString("name",name);
        editor.putString("pass",pass);
        editor.commit();
    }
    public HashMap<String, String> retrive(){
        String name=sharedPreferences.getString("name","Name is Empty");
        String password=sharedPreferences.getString("pass","Password is Empty");
        //list=new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("name",name);
        map.put("pass",password);
       // list.add(map);
        return map;
    }
    public void delete(){
        editor.remove("name");
        editor.remove("pass");
        editor.commit();
    }
}
