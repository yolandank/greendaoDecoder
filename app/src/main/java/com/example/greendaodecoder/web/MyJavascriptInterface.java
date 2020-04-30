package com.example.greendaodecoder.web;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class MyJavascriptInterface {
    /**
     * Created by jingbin on 2016/11/17.
     * js通信接口
     */

    private Context context;
    private static final String TAG = "MyJavascriptInterface";
    public MyJavascriptInterface(Context context) {
        this.context = context;
    }

    /**
     * 前端代码嵌入js：
     * imageClick 名应和js函数方法名一致
     *
     * @param src 图片的链接
     */
    @JavascriptInterface
    public void imageClick(String src) {
        Log.e(TAG, "----点击了图片");
        Log.e(TAG, src);
    }

    /**
     * 前端代码嵌入js
     * 遍历<li>节点
     *
     * @param type    <li>节点下type属性的值
     * @param item_pk item_pk属性的值
     */
    @JavascriptInterface
    public void textClick(String type, String item_pk) {
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(item_pk)) {
            Log.e(TAG, "----点击了文字");
            Log.e(TAG, type);
            Log.e(TAG, item_pk);
        }
    }



    /**
     * 网页使用的js，方法无参数
     */
    @JavascriptInterface
    public void startFunction() {
        Log.e(TAG, "----无参");
    }

    /**
     * 网页使用的js，方法有参数，且参数名为data
     *
     * @param data 网页js里的参数名
     */
    @JavascriptInterface
    public void startFunction(String data) {
        Log.e(TAG, "----有参" + data);
    }
}
