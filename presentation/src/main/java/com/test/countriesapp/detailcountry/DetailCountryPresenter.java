package com.test.countriesapp.detailcountry;

import android.support.annotation.VisibleForTesting;

import com.arellomobile.mvp.InjectViewState;
import com.example.usecases.CountryFlagUseCase;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.base.BasePresenter;
import com.test.countriesapp.base.BaseSubscriber;
import com.test.countriesapp.utils.StringUtils;

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
    public void inject() {
        MyApp.getDetailCountryComponent().inject(this);
    }

    void loadCountryFlagInSvgFormat(String alpha3Code) {
        if (countryFlagUseCase == null) return;
        if (StringUtils.isEmpty(alpha3Code)) return;
        countryFlagUseCase.execute(new LoadFlagSubscriber(), null);
    }

    void actionAfterSuccessResponse(byte[] bitmapByteArray) {
        getViewState().renderCountryFlag(bitmapByteArray);
    }

    void actionAfterErrorResponse(final String message) {
        getViewState().showLoadErrorMessage(message);
    }

    private class LoadFlagSubscriber extends BaseSubscriber<byte[]> {
        @Override
        public void onNext(byte[] bitmapByteArray) {
            if (bitmapByteArray == null) return;
            actionAfterSuccessResponse(bitmapByteArray);
        }

        @Override
        public void onError(Throwable t) {
            Logger.e("LoadFlagSubscriber = " + t.getMessage());
            actionAfterErrorResponse(t.getMessage());
        }
    }

    @VisibleForTesting
    void setCountryFlagUseCase(CountryFlagUseCase countryFlagUseCase) {
        this.countryFlagUseCase = countryFlagUseCase;
    }
}
