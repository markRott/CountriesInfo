package com.test.countriesapp.countries;

import com.arellomobile.mvp.MvpView;
import com.example.models.CountryDomainModel;

import java.util.Collection;

/**
 * Created by sma on 10.10.17.
 */

public interface ICountriesView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void showErrorMessage(String errorMsg);

    void hideErrorMessage();

    void renderCountriesList(Collection<CountryDomainModel> countryList);
}
