package com.test.countriesapp.base;

import com.arellomobile.mvp.MvpPresenter;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import java.net.HttpURLConnection;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BasePresenter<View extends IMvpViewWithUnauthorized> extends MvpPresenter<View> {

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
    }

    public void inject() {
    }

    protected boolean isUnauthorizeException(Throwable throwable) {
        return (((HttpException) throwable).code() == HttpURLConnection.HTTP_UNAUTHORIZED);
    }

}
