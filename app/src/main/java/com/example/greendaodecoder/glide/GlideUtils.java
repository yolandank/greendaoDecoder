package com.example.greendaodecoder.glide;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.greendaodecoder.DemoApp;
import com.example.greendaodecoder.GlideApp;
import com.example.greendaodecoder.R;

public class GlideUtils {
    private static volatile GlideUtils instance;

    private GlideUtils() {

    }

    public static GlideUtils getInstance() {
        if (instance == null) {
            synchronized (GlideUtils.class) {
                if (instance == null) {
                    instance = new GlideUtils();
                }
            }
        }
        return instance;
    }

    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1584521342193&di=d5331b4f0f4bcee18a81aa0f96a631b4&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F11b10aa3d711baa41e414bc611676c833534a57f.png";

    public void init() {
        View view = LayoutInflater.from(DemoApp.app).inflate(R.layout.activity_main, null);
        ImageView imageView = view.findViewById(R.id.image);
        GlideApp.with(DemoApp.app).load(url).into(imageView);
    }
}
