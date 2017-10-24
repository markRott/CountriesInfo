package com.test.countriesapp.countries;

import com.example.models.CountryDomainModel;
import com.test.countriesapp.base.IMvpViewWithUnauthorized;

import java.util.Collection;

/**
 * Created by sma on 10.10.17.
 */

public interface ICountriesView extends IMvpViewWithUnauthorized {

    void showProgressBar();

    void hideProgressBar();

    void showErrorMessage(String errorMsg);

    void hideErrorMessage();

    void renderCountriesList(Collection<CountryDomainModel> countryList);
}
