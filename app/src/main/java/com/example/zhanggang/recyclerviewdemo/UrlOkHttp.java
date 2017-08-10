package com.example.zhanggang.recyclerviewdemo;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * 类作用：
 * 时  间：2017/8/10 - 19:35.
 * 创建人：张刚
 */

public class UrlOkHttp {
    public static void sendOkHttpRequest(String address, Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);

    }
}
