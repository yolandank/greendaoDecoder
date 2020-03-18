package com.example.greendaodecoder.okhttp;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtils {
    private static volatile OkHttpUtils instance;

    private OkHttpUtils() {

    }

    public static OkHttpUtils getInstance() {
        if (instance == null) {
            synchronized (OkHttpUtils.class) {
                if (instance == null) {
                    instance = new OkHttpUtils();
                }
            }
        }
        return instance;
    }

    public void initNet() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();
        Request.Builder requestBuilder = new Request.Builder();
        requestBuilder.url("www.baidu.com");
        Request request = requestBuilder.build();
        try {
            // execute 就是同步执行的
            // enqueue 就是异步请求，需要设置回调
            Response response = client.newCall(request).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
