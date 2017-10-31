package com.test.countriesapp.detailcountry;

import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.example.models.CountryDomainModel;
import com.test.countriesapp.base.IMvpViewWithUnauthorized;

/**
 * Created by sma on 12.10.17.
 */

public interface IDetailCountryView extends IMvpViewWithUnauthorized {

    @StateStrategyType(value = OneExecutionStateStrategy.class)
    void startLoadFlag(String url);

    @StateStrategyType(value = SingleStateStrategy.class)
    void renderCountryFlag(byte[] bytes);

    @StateStrategyType(value = SingleStateStrategy.class)
    void showLoadErrorMessage(final String errorMessage);

    @StateStrategyType(value = OneExecutionStateStrategy.class)
    void fillViews(final CountryDomainModel model);
}
