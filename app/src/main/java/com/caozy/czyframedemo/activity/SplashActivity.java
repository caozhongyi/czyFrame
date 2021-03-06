package com.caozy.czyframedemo.activity;

import com.caozy.base.activity.BaseNetActivity;
import com.caozy.czyframedemo.R;
import com.caozy.net.Api;
import com.caozy.net.BaseBean;
import com.caozy.net.Net;

import io.reactivex.Observable;

public class SplashActivity extends BaseNetActivity {

    @Override
    public int getContent() {
        return R.layout.activity_main;
    }

    @Override
    public void onNetSuccess(Object o) {

    }

    @Override
    public void onNetFail() {
    }

    @Override
    public Observable getNetObservable(Api api) {
        return api.comment("", "", "", "", "", "");
//        return null;
    }
}
