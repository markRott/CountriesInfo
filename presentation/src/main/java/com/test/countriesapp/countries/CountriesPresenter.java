package com.test.countriesapp.countries;

import android.support.annotation.VisibleForTesting;

import com.arellomobile.mvp.InjectViewState;
import com.example.models.CountryDomainModel;
import com.example.usecases.CountriesUseCase;
import com.test.countriesapp.Const;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.base.BasePresenter;
import com.example.BaseSubscriber;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

@InjectViewState
public class CountriesPresenter extends BasePresenter<ICountriesView> {

    @Inject
    Router router;
    @Inject
    CountriesUseCase countriesUseCase;

    @Override
    public void inject() {
        MyApp.getCountriesComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        fetchCountries();
    }

    public void openDetailScreen(CountryDomainModel data) {
        router.navigateTo(Const.ScreenKey.DETAIL_COUNTRY, data);
    }

    public void fetchCountries() {
        if (countriesUseCase == null) return;
        getViewState().showProgressBar();
        countriesUseCase.execute(new CountriesObserver(), null);
    }

    public void openLoginScreen() {
//        router.newRootScreen(Const.ScreenKey.LOGIN_SCREEN);
    }

    void actionAfterSuccessResponse(final List<CountryDomainModel> countryDomainModels) {
        getViewState().hideProgressBar();
        getViewState().renderCountriesList(countryDomainModels);
    }

    void actionAfterErrorResponse(String message) {
        getViewState().hideProgressBar();
        getViewState().showErrorMessage(message);
    }

    void actionAfterUnautorizeExeption() {
        getViewState().unauthorize();
    }

    private final class CountriesObserver extends BaseSubscriber<List<CountryDomainModel>> {

        @Override
        public void onNext(List<CountryDomainModel> countryDomainModels) {
            actionAfterSuccessResponse(countryDomainModels);
        }

        @Override
        public void onError(Throwable t) {
            super.onError(t);
            actionAfterErrorResponse(t.getMessage());
            if (isUnauthorizeException(t)) {
                actionAfterUnautorizeExeption();
            }
        }
    }

    @VisibleForTesting
    public void setRouter(Router router) {
        this.router = router;
    }

    @VisibleForTesting
    public void setCountriesUseCase(CountriesUseCase countriesUseCase) {
        this.countriesUseCase = countriesUseCase;
    }
}
