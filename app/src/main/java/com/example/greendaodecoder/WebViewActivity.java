package com.example.greendaodecoder;

import android.os.Bundle;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.greendaodecoder.web.WebViewDemo;


public class WebViewActivity extends AppCompatActivity {
    WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity_layout);
        FrameLayout webViewContainer = findViewById(R.id.webview_container);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mWebview = WebViewDemo.getInstance().getWebView(this);
        webViewContainer.addView(mWebview, params);
        TextView callJsFunction = findViewById(R.id.call_js_function_no_param);
        callJsFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebview.loadUrl("javascript:javacalljs()");
            }
        });
        TextView callJsFunctionWithParam = findViewById(R.id.call_js_function_with_param);
        callJsFunctionWithParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "红毛浮绿水";
                mWebview.loadUrl("javascript:javacalljswithargs('" + data + "')");
            }
        });
    }

    //点击返回上一页面而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
            mWebview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        if (mWebview != null) {
            mWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebview.clearHistory();

            ((ViewGroup) mWebview.getParent()).removeView(mWebview);
            mWebview.destroy();
            mWebview = null;
        }
        super.onDestroy();
    }
}
