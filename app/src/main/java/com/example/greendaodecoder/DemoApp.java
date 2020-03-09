package com.example.greendaodecoder;

import android.app.Application;

public class DemoApp extends Application {
    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
