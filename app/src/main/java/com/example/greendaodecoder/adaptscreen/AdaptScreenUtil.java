package com.example.greendaodecoder.adaptscreen;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;

import android.util.DisplayMetrics;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AdaptScreenUtil {
    private static final String TAG = "AdaptScreenUtil";
    private static float sNonCompatDensity;
    private static float sNonCompatScaledDensity;

    public static void setCustomDensity(@NonNull AppCompatActivity activity, @NonNull final Application application) {
        DisplayMetrics metrics = application.getResources().getDisplayMetrics();

        if(0 == sNonCompatDensity) {
            sNonCompatDensity = metrics.density;
            sNonCompatScaledDensity = metrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if(null != newConfig && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        Log.d(TAG, "setCustomDensity: sNonCompatDensity="+sNonCompatDensity);
        Log.d(TAG, "setCustomDensity: sNonCompatScaledDensity="+sNonCompatScaledDensity);
        final float targetDensity = metrics.widthPixels / 750f;
        final float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);
        Log.d(TAG, "setCustomDensity: targetDensity = "+targetDensity);
        Log.d(TAG, "setCustomDensity: targetScaledDensity = "+targetScaledDensity);
        Log.d(TAG, "setCustomDensity: targetDensityDpi = "+targetDensityDpi);
        metrics.density = targetDensity;
        metrics.scaledDensity = targetScaledDensity;
        metrics.densityDpi = targetDensityDpi;

        DisplayMetrics activityMetrics = activity.getResources().getDisplayMetrics();
        activityMetrics.density = targetDensity;
        activityMetrics.scaledDensity = targetScaledDensity;
        activityMetrics.densityDpi = targetDensityDpi;
    }
    public static void setAppCustomDensity(@NonNull final Application application) {
        DisplayMetrics metrics = application.getResources().getDisplayMetrics();

        if(0 == sNonCompatDensity) {
            sNonCompatDensity = metrics.density;
            sNonCompatScaledDensity = metrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if(null != newConfig && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        Log.d(TAG, "setCustomDensity: sNonCompatDensity="+sNonCompatDensity);
        Log.d(TAG, "setCustomDensity: sNonCompatScaledDensity="+sNonCompatScaledDensity);
        final float targetDensity = metrics.widthPixels / 750f;
        final float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);
        Log.d(TAG, "setCustomDensity: targetDensity = "+targetDensity);
        Log.d(TAG, "setCustomDensity: targetScaledDensity = "+targetScaledDensity);
        Log.d(TAG, "setCustomDensity: targetDensityDpi = "+targetDensityDpi);
        metrics.density = targetDensity;
        metrics.scaledDensity = targetScaledDensity;
        metrics.densityDpi = targetDensityDpi;
    }
    public static void setActivityCustomDensity(@NonNull final AppCompatActivity activity) {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();

        if(0 == sNonCompatDensity) {
            sNonCompatDensity = metrics.density;
            sNonCompatScaledDensity = metrics.scaledDensity;
            activity.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if(null != newConfig && newConfig.fontScale > 0) {
                        sNonCompatScaledDensity = activity.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        Log.d(TAG, "setCustomDensity: sNonCompatDensity="+sNonCompatDensity);
        Log.d(TAG, "setCustomDensity: sNonCompatScaledDensity="+sNonCompatScaledDensity);
        final float targetDensity = metrics.widthPixels / 750f;
        final float targetScaledDensity = targetDensity * (sNonCompatScaledDensity / sNonCompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);
        Log.d(TAG, "setCustomDensity: targetDensity = "+targetDensity);
        Log.d(TAG, "setCustomDensity: targetScaledDensity = "+targetScaledDensity);
        Log.d(TAG, "setCustomDensity: targetDensityDpi = "+targetDensityDpi);
        metrics.density = targetDensity;
        metrics.scaledDensity = targetScaledDensity;
        metrics.densityDpi = targetDensityDpi;
    }
    
    public static void printCurrentDensity(Context context,String contextName){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        Log.d(TAG, "printCurrentDensity: "+contextName+" density="+metrics.density);
        Log.d(TAG, "printCurrentDensity: "+contextName+" densityDpi="+metrics.densityDpi);
        Log.d(TAG, "printCurrentDensity: "+contextName+" scaledDensity="+metrics.scaledDensity);
    }
}

