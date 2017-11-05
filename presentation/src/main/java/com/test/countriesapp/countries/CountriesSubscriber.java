package com.test.countriesapp.countries;

import com.example.BaseSubscriber;
import com.example.models.CountryDomainModel;

import java.util.List;

/**
 * Created by sma on 05.11.17.
 */

public class CountriesSubscriber extends BaseSubscriber<List<CountryDomainModel>> {

    private final ICountriesView view;

    public CountriesSubscriber(ICountriesView view) {
        this.view = view;
    }

    @Override
    public void onNext(List<CountryDomainModel> countryDomainModels) {
        view.hideProgressBar();
        view.renderCountriesList(countryDomainModels);
    }

    @Override
    public void onError(Throwable t) {
        view.hideProgressBar();
        view.showErrorMessage(t.getMessage());
    }
}
