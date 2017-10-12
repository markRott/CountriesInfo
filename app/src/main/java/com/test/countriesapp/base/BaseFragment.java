package com.test.countriesapp.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.test.countriesapp.Const;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.countries.CountriesComponent;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    public abstract void inject();

    MyApp myApp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    public MyApp getMyApp() {
        return (MyApp) getActivity().getApplication();
    }

    public CountriesComponent getCountriesComponent() {
        return getMyApp().getCountriesComponent();
    }

    public <T> T getModelFromArgs() {
        final Bundle bundle = getArguments();
        if (bundle == null) return null;
        return (T) bundle.getSerializable(Const.ArgsKey.COUNTRY_DETAIL);
    }

}
