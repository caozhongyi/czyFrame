package com.caozy.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.caozy.net.Api;
import com.caozy.net.Net;
import com.caozy.net.NetObserver;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseNetActivity extends BaseActivity implements NetObserver.OnNetResponseListener {

    Observable observable;
    NetObserver netObserver;

    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        getNetObservable(Net.getService());
        netObserver = new NetObserver();
        netObserver.setResponseListener(this);
        if (observable != null) {
            observable
                    .observeOn(Schedulers.io())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {

                        }
                    })
                    .subscribeOn(AndroidSchedulers.mainThread())
                    .subscribe(netObserver);
        }
    }

    //    @Override
//    public abstract int getContent();

    /**
     *   实现此方法，获取 网络请求的 Observable
     *   （通过 Net.getService()
     *      调用 retrofit 定义的接口
     *      生成 Observable
     *   ）
     * @return
     */
    public abstract <B> Observable<B> getNetObservable(Api api);



//    @Override
//    public abstract void onNetFail();

}
