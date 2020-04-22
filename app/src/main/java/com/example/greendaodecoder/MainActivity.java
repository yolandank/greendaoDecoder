package com.example.greendaodecoder;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodecoder.concurrent.FutureDemo;
import com.example.greendaodecoder.concurrent.FutureTaskDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FutureDemo.getInstance().run();
        FutureTaskDemo.getInstance().run();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataUtils.getInstance().removeItem(12);
    }

    private static final String TAG = "MainActivity";

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.d(TAG, "dispatchKeyEvent: ");
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: ");
        return super.onTouchEvent(event);
    }
}
