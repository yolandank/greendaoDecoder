package com.example.greendaodecoder;

import android.app.Application;

import com.example.greendaodecoder.adaptscreen.AdaptScreenUtil;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;


public class DemoApp extends Application {
    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AdaptScreenUtil.setAppCustomDensity(this);
        AdaptScreenUtil.printCurrentDensity(this, this.getClass().getSimpleName());
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        sRefWatcher = LeakCanary.install(this);
    }

    private static RefWatcher sRefWatcher;

    public static RefWatcher getRefWatcher() {
        return sRefWatcher;
    }
}
