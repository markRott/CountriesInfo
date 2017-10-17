package com.test.countriesapp.detailcountry;

import android.text.TextUtils;

import com.arellomobile.mvp.InjectViewState;
import com.example.usecases.CountryFlagUseCase;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.base.BasePresenter;
import com.test.countriesapp.base.BaseSubscriber;

import javax.inject.Inject;

/**
 * Created by sma on 12.10.17.
 */

@InjectViewState
public class DetailCountryPresenter extends BasePresenter<IDetailCountryView> {

    @Inject
    CountryFlagUseCase countryFlagUseCase;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().startLoadFlag();
    }

    @Override
    public void attachView(IDetailCountryView view) {
        Logger.i("attachView");
        super.attachView(view);
    }

    @Override
    public void detachView(IDetailCountryView view) {
        super.detachView(view);
        Logger.i("detachView");
    }

    @Override
    public void destroyView(IDetailCountryView view) {
        super.destroyView(view);
        Logger.i("destroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.i("onDestroy");
    }

    @Override
    public void inject() {
        MyApp.getDetailCountryComponent().inject(this);
    }

    void loadCountryFlagInSvgFormat(String alpha3Code) {
        if (TextUtils.isEmpty(alpha3Code)) return;
        countryFlagUseCase.execute(new LoadFlagSubscriber(), null);
    }

    private class LoadFlagSubscriber extends BaseSubscriber<byte[]> {
        @Override
        public void onNext(byte[] o) {
            if (o == null) return;
            getViewState().renderCountryFlag(o);
        }

        @Override
        public void onError(Throwable t) {
            Logger.e("LoadFlagSubscriber = " + t.getMessage());
        }
    }
}
