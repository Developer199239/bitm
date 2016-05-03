package com.example.bitmtrainer401.webservicedemo;

import android.accounts.NetworkErrorException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String url = "http://nerdcastlebd.com/_old-site/web_service/banglapoems/index.php/poets/all/format/json";
    ArrayList<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        nameList = new ArrayList<>();
        getPoetNames();

    }

    private void getPoetNames() {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                try {

                    JSONArray array = response.getJSONArray("poets");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String name = object.getString("name");
                        nameList.add(name);

                    }
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, nameList);
                    listView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NoConnectionError){
                    Toast.makeText(MainActivity.this, "NO Internet Connection", Toast.LENGTH_SHORT).show();
                }

                Log.i("Error",error.getMessage());
            }
        });
        AppController.getInstance().addToRequestQueue(request);

    }
}
