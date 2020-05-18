package com.example.greendaodecoder.jetpack;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.greendaodecoder.DemoApp;

public class SimpleWorker extends Worker {
    private static final String TAG = "SimpleWorker";
    private Data data = null;

    public SimpleWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        data = getInputData();
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "doWork: " + getInputData().getString("1653"));
        DemoApp.sHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(DemoApp.app, "绿萝狂喜", Toast.LENGTH_SHORT).show();
            }
        });
        return Result.success();
    }


}
