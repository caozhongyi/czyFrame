package com.caozy.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net {

    /**   生产地址(域名)(此处生产地址采用final，保证当为生产包时这个域名不会被修改)  */
    private static final String BASE_URL = "http://app.qudongdong.com/yixing_sports/";//这里最后一定要有一个 "/"

    public Net() {
    }

    private Retrofit retrofit = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .client(Okhttp.getOkHttpClient())
            .build();

    private Api api = retrofit.create(Api.class);

    private static class RetrofitUtilInstance {
        private static final Net INSTANCE = new Net();
    }

    public static Net getInstance() {
        return RetrofitUtilInstance.INSTANCE;
    }

    public static Api getService() {
        return getInstance().api;
    }

}
