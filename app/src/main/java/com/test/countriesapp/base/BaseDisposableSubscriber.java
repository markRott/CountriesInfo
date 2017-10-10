package com.test.countriesapp.base;

import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 10.10.17.
 */

public class BaseDisposableSubscriber <T> extends DisposableSubscriber<T> {

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
