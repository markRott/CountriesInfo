package com.test.countriesapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.test.countriesapp.dagger2.ComponentsHelper;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.countries.CountriesComponent;

/**
 * Created by sma on 10.10.17.
 */

public class MyApp extends Application {

    private MyAppComponent appComponent;
    private CountriesComponent countriesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initLeak();
        initAppComponent();
    }

    private void initLeak() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public MyAppComponent getAppComponent() {
        return appComponent;
    }

    public CountriesComponent getCountriesComponent() {
        return countriesComponent;
    }

    public void initCountriesComponent() {
        countriesComponent = ComponentsHelper.initCountriesComponent();
    }

    private void initAppComponent() {
        appComponent = ComponentsHelper.initMyAppComponent(this);
    }
}
