package com.example.faravy.myapplication;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Faravy on 24-Mar-16.
 */
public class AppController extends Application {
    private RequestQueue mRequestQueue;
    private static AppController mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public static synchronized AppController getInstance() {
        return mInstance;
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }
    public void addToRequestQueue(Request req) {
        getRequestQueue().add(req);
    }


}
