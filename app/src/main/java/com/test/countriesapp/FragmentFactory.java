package com.test.countriesapp;

import android.support.v4.app.Fragment;

import com.test.countriesapp.countries.CountriesFragment;

/**
 * Created by sma on 10.10.17.
 */

public class FragmentFactory {

    private FragmentFactory() {
    }

    public static Fragment getFragmentByKey(final String key, final Object data) {
        switch (key) {

            case Const.ScreenKey.COUNTRIES:
                return CountriesFragment.newInstance();

            case Const.ScreenKey.DETAIL_COUNTRY:
                return null;

            default:
                return null;
        }
    }
}
