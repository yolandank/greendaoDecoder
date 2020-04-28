package com.example.greendaodecoder.web;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemo {
    private static volatile  WebViewDemo instance;

    private WebViewDemo() {

    }

    public static WebViewDemo getInstance() {
     if (instance == null) {
         synchronized (WebViewDemo.class) {
             if (instance == null) {
                 instance = new WebViewDemo();
             }
         }
     }
     return instance;
    }

    public void  setWebViewClient(final WebView webView){
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
}
