package com.test.countriesapp.countries;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
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

    @StateStrategyType(value = OneExecutionStateStrategy.class)
    void renderCountriesList(Collection<CountryDomainModel> countryList);
}
