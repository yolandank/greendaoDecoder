package com.example.greendaodecoder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RedFameLayout extends FrameLayout {
    public RedFameLayout(@NonNull Context context) {
        super(context);
    }

    private static final String TAG = "RedFameLayout";
    public RedFameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch: RedFameLayout");
                return false;
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: RedFameLayout");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: RedFameLayout");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: RedFameLayout");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.d(TAG, "onInterceptTouchEvent: RedFameLayout");
        return super.onInterceptTouchEvent(ev);
    }
}
