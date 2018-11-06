package com.caozy.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Okhttp {

    /**
     * 通用OkHttpClient (项目中大多数请求形式统一的用这一个)
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new RequestInterceptor())
                .build();
        return client;
    }



}
