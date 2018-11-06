package com.caozy.net;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NetObserver<T extends BaseBean> implements Observer<T> {

    private OnNetResponseListener responseListener;

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
        //在这里对返回的结果进行预处理
        if (t.getCode() == 1) {
        }

        if (responseListener != null) {
            responseListener.onNetSuccess(t);
        }
    }


    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public interface OnNetResponseListener<B> {
        void onNetSuccess(B b);

        void onNetFail();
    }

    public OnNetResponseListener getResponseListener() {
        return responseListener;
    }

    public void setResponseListener(OnNetResponseListener responseListener) {
        this.responseListener = responseListener;
    }
}
