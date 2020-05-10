package com.example.greendaodecoder.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.greendaodecoder.DemoApp;

public class VolleyDemo {
    private static volatile  VolleyDemo instance;
    private RequestQueue mQueue;
    private VolleyDemo() {
        mQueue= Volley.newRequestQueue(DemoApp.app);
    }

    public static VolleyDemo getInstance(   ) {
        if (instance == null) {
            synchronized (VolleyDemo.class) {
                if (instance == null) {
                    instance = new VolleyDemo( );
                }
            }
        }
        return instance;
    }

    private static final String TAG = "VolleyDemo";
    public void run(){
        StringRequest request=new StringRequest("http://www.baidu.com", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: response=" + response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: error="+error.getMessage());
            }
        });
        mQueue.add(request);
    }
}
