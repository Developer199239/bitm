package com.example.faravy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {
    String urlToLogin;
    JSONObject loginObject;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urlToLogin = "http://dotnet.nerdcastlebd.com/meal/api/users/post";
        loginObject = new JSONObject();
        try {
            loginObject.put("UserId", "rakib");
            loginObject.put("Password", "1234");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, urlToLogin, loginObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("Response",response.toString());
                try {
                    boolean result=response.getBoolean("ResultState");
                    Toast.makeText(MainActivity.this, String.valueOf(result), Toast.LENGTH_SHORT).show();
                    if (result){
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(request);
    }
}
