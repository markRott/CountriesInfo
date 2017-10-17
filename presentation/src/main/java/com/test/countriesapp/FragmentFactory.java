package com.test.countriesapp;

import android.support.v4.app.Fragment;

import com.example.models.CountryDomainModel;
import com.test.countriesapp.countries.CountriesFragment;
import com.test.countriesapp.detailcountry.DetailCountryFragment;

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
                return DetailCountryFragment.newInstance((CountryDomainModel) data);

            default:
                return null;
        }
    }
}
