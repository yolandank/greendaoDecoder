package com.example.greendaodecoder.tools;

import android.content.Context;

public class CommonUtils {
    private static volatile CommonUtils instance;
    private Context mContext;

    private CommonUtils(Context context) {
        this.mContext = context;
    }

    public static CommonUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (CommonUtils.class) {
                if (instance == null) {
                    instance = new CommonUtils(context);
                }
            }
        }
        return instance;
    }
}
