package com.example.greendaodecoder.web;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewDemo {
    private static volatile WebViewDemo instance;

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

    private static final String TAG = "WebViewDemo";

    public WebView getWebView(Context mContext) {
        WebView mWebview = new WebView(mContext);
        WebSettings mWebSettings = mWebview.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ONLY);
        mWebview.loadUrl("file:///android_asset/Demo.html");
        CookieManager.getInstance().flush();
        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWebview.setWebChromeClient(new WebChromeClient() {
            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                Log.d(TAG, "onReceivedTitle: 标题在这里");
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    String progress = newProgress + "%";
                    Log.d(TAG, "onProgressChanged:<100 progress=" + progress);
                } else if (newProgress == 100) {
                    String progress = newProgress + "%";
                    Log.d(TAG, "onProgressChanged: == 100 progress = " + progress);
                }
            }
        });


        //设置WebViewClient类
        mWebview.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载了");
                Log.d(TAG, "onPageStarted: 开始加载了");
            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "onPageFinished: 结束加载了");
            }
        });
        mWebview.addJavascriptInterface(new MyJavascriptInterface(mContext), "injectedObject");
        return mWebview;
    }

}
