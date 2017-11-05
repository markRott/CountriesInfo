package com.test.countriesapp.detailcountry;

import android.support.annotation.VisibleForTesting;

import com.arellomobile.mvp.InjectViewState;
import com.example.BaseSubscriber;
import com.example.models.CountryDomainModel;
import com.example.usecases.CountryFlagUseCase;
import com.test.countriesapp.base.BasePresenter;
import com.test.countriesapp.dagger2.ComponentsHelper;
import com.test.countriesapp.utils.StringUtils;

import javax.inject.Inject;

/**
 * Created by sma on 12.10.17.
 */

@InjectViewState
public class DetailCountryPresenter extends BasePresenter<IDetailCountryView> {

    @Inject
    CountryFlagUseCase countryFlagUseCase;
    @Inject
    CountryDomainModel model;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().fillViews(model);
        loadCountryFlagInSvgFormat(model.getUrlForLoadFlag());
    }

    @Override
    public void inject() {
        ComponentsHelper.getDetailCountryComponent().inject(this);
    }

    @Override
    public void destroy() {
        countryFlagUseCase.dispose();
        model = null;
        countryFlagUseCase = null;
    }

    void loadCountryFlagInSvgFormat(String alpha3Code) {
        if (countryFlagUseCase == null) return;
        if (StringUtils.isEmpty(alpha3Code)) return;
        countryFlagUseCase.execute(new LoadFlagSubscriber(), null);
    }

    public void openLoginScreen() {

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
            actionAfterErrorResponse(t.getMessage());
        }
    }

    @VisibleForTesting
    void setCountryFlagUseCase(CountryFlagUseCase countryFlagUseCase) {
        this.countryFlagUseCase = countryFlagUseCase;
    }
}
