package com.test.countriesapp.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.countries.CountriesComponent;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    public abstract void inject();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    public CountriesComponent getCountriesComponent() {
        return ((MyApp) getActivity().getApplication()).getCountriesComponent();
    }

}
