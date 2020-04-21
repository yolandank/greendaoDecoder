package com.example.greendaodecoder.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class YellowView extends View {
    public YellowView(Context context) {
        super(context);
    }

    private static final String TAG = "YellowView";
    public YellowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "onTouch: YellowView");
                return false;
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: YellowView");
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: YellowView");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent: YellowView");
        return super.dispatchTouchEvent(event);
    }
}
