package com.test.countriesapp.detailcountry;

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.models.CountryDomainModel;
import com.test.countriesapp.base.IMvpViewWithUnauthorized;

/**
 * Created by sma on 12.10.17.
 */

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface IDetailCountryView extends IMvpViewWithUnauthorized {

    void renderCountryFlag(byte[] bytes);

    void showLoadErrorMessage(final String errorMessage);

    void fillViews(final CountryDomainModel model);
}
