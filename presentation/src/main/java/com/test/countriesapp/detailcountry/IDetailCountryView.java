package com.test.countriesapp.detailcountry;

import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.test.countriesapp.base.IMvpViewWithUnauthorized;

/**
 * Created by sma on 12.10.17.
 */

public interface IDetailCountryView extends IMvpViewWithUnauthorized {

    void startLoadFlag();

    @StateStrategyType(value = SingleStateStrategy.class)
    void renderCountryFlag(byte[] bytes);

    @StateStrategyType(value = SingleStateStrategy.class)
    void showLoadErrorMessage(final String errorMessage);
}
