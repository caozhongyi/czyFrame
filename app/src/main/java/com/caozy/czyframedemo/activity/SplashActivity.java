package com.caozy.czyframedemo.activity;

import com.caozy.base.activity.BaseNetActivity;
import com.caozy.net.BaseBean;

import io.reactivex.Observable;

public class SplashActivity extends BaseNetActivity {

    @Override
    public Observable getNetObservable() {
        return null;
    }

    @Override
    public int getContent() {
        return 0;
    }

    @Override
    public void onNetSuccess(Object o) {

    }

    @Override
    public void onNetFail() {

    }
}
