package com.test.countriesapp.countries;

import com.arellomobile.mvp.InjectViewState;
import com.example.models.CountryDomainModel;
import com.example.usecases.CountriesUseCase;
import com.test.countriesapp.Const;
import com.test.countriesapp.base.BaseDisposableSubscriber;
import com.test.countriesapp.base.BasePresenter;

import java.util.List;

import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

@InjectViewState
public class CountriesPresenter extends BasePresenter<ICountriesView> {

    Router router;
    CountriesUseCase countriesUseCase;
    
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        fetchCountries();
    }

    public CountriesPresenter setRouter(Router router) {
        this.router = router;
        return this;
    }

    public CountriesPresenter setCountriesUseCase(CountriesUseCase countriesUseCase) {
        this.countriesUseCase = countriesUseCase;
        return this;
    }

    public void openDetailScreen(CountryDomainModel data) {
        router.navigateTo(Const.ScreenKey.DETAIL_COUNTRY, data);
    }

    private void fetchCountries() {
        if (countriesUseCase == null) return;
        getViewState().showProgressBar();
        countriesUseCase.execute(new CountriesObserver(), null);
    }

    private final class CountriesObserver extends BaseDisposableSubscriber<List<CountryDomainModel>> {

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
