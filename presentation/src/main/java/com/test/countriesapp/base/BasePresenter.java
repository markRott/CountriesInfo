package com.test.countriesapp.base;

import com.arellomobile.mvp.MvpPresenter;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BasePresenter<View extends IMvpViewWithUnauthorized> extends MvpPresenter<View> {


    public abstract void destroy();

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        inject();
    }

    public void inject() {
    }
}
