package com.faravy.bitmtrainer401.sharedpreferenceexample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by BITM Trainer 401 on 3/7/2016.
 */
public class Preference {

   private SharedPreferences sharedPreferences;
   private SharedPreferences.Editor editor;
   private Context context;

    static final String PREFERENCE_NAME = "batch13";
    static final String NAME_KEY="name";

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public  void saveUserData(String name){
        editor.putString(NAME_KEY, name);
        editor.commit();


    }
    public  String retrieveUserData(){

        String name = sharedPreferences.getString(NAME_KEY, "Data Not Found");
        return name;
    }

}
