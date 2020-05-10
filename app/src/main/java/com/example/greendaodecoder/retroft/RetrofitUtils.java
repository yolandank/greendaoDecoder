package com.example.greendaodecoder.retroft;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static final String TAG = "RetrofitUtils";
    private static volatile RetrofitUtils instance;

    private RetrofitUtils() {

    }

    public static RetrofitUtils getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtils.class) {
                if (instance == null) {
                    instance = new RetrofitUtils();
                }
            }
        }
        return instance;
    }

    public void createClient() {
        Retrofit.Builder builder = new Retrofit.Builder();
        RxJavaCallAdapterFactory rxFactory = RxJavaCallAdapterFactory.createAsync();
        builder.client(new OkHttpClient());
        builder.addCallAdapterFactory(rxFactory);
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        GrabService grabService = retrofit.create(GrabService.class);
        grabService.listRepos("renwj");


    }

}

