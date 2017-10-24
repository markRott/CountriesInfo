package com.test.countriesapp.info;

import com.test.countriesapp.base.IMvpViewWithUnauthorized;

/**
 * Created by sma on 10.10.17.
 */

public interface IInfoView extends IMvpViewWithUnauthorized {

    void showClearDatabaseMessage(boolean deleteState);
}
