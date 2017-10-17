package com.test.countriesapp.countries;

import com.arellomobile.mvp.InjectViewState;
import com.example.models.CountryDomainModel;
import com.example.usecases.CountriesUseCase;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.Const;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.base.BaseSubscriber;
import com.test.countriesapp.base.BasePresenter;

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

    @Override
    public void attachView(ICountriesView view) {
        super.attachView(view);
        Logger.i("attachView");
    }

    @Override
    public void detachView(ICountriesView view) {
        super.detachView(view);
        Logger.i("detachView");
    }

    @Override
    public void destroyView(ICountriesView view) {
        super.destroyView(view);
        Logger.i("destroyView");
    }

    @Override
    public boolean isInRestoreState(ICountriesView view) {
        Logger.i("isInRestoreState");
        return super.isInRestoreState(view);
    }

    @Override
    public void onDestroy() {
        Logger.i("onDestroy");
        super.onDestroy();
    }

    public void openDetailScreen(CountryDomainModel data) {
        router.navigateTo(Const.ScreenKey.DETAIL_COUNTRY, data);
    }

    private void fetchCountries() {
        if (countriesUseCase == null) return;
        getViewState().showProgressBar();
        countriesUseCase.execute(new CountriesObserver(), null);
    }

    private final class CountriesObserver extends BaseSubscriber<List<CountryDomainModel>> {

        @Override
        public void onNext(List<CountryDomainModel> countryDomainModels) {
            getViewState().hideProgressBar();
            getViewState().renderCountriesList(countryDomainModels);
        }

        @Override
        public void onError(Throwable t) {
            getViewState().hideProgressBar();
            getViewState().showErrorMessage(t.getMessage());
        }
    }

}
