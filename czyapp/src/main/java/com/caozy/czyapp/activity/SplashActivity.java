package com.caozy.czyapp.activity;

import com.caozy.base.activity.BaseNetActivity;
import com.caozy.czyapp.User;
import com.caozy.net.Api;

import io.reactivex.Observable;

public class SplashActivity extends BaseNetActivity {


    @Override
    public Observable<User> getNetObservable(Api api) {
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
