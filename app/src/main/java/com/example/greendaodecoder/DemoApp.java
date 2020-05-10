package com.example.greendaodecoder;

import android.app.Application;

import com.example.greendaodecoder.adaptscreen.AdaptScreenUtil;

public class DemoApp extends Application {
    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AdaptScreenUtil.setAppCustomDensity(this);
        AdaptScreenUtil.printCurrentDensity(this,this.getClass().getSimpleName());
    }
}
