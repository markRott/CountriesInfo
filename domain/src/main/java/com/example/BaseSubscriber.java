package com.example;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 10.10.17.
 */

public class BaseSubscriber<T> extends DisposableSubscriber<T> {

    @Override
    public void onNext(T o) {

    }

    @Override
    public void onError(Throwable t) {
    }

    @Override
    public void onComplete() {

    }
}
