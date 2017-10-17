package com.test.countriesapp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.test.countriesapp.dagger2.ComponentsHelper;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.countries.CountriesComponent;

import io.realm.Realm;

/**
 * Created by sma on 10.10.17.
 */

public class MyApp extends Application {

    private static MyAppComponent appComponent;
    private static CountriesComponent countriesComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        initRealm();
        initLeak();

        initAppComponent();
    }

    public static MyAppComponent getAppComponent() {
        return appComponent;
    }

    public static CountriesComponent getCountriesComponent() {
        return countriesComponent;
    }

    public static void initCountriesComponent() {
        countriesComponent = ComponentsHelper.initCountriesComponent(appComponent);
    }

    private void initRealm() {
        Realm.init(this);
    }

    private void initLeak() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    private void initAppComponent() {
        appComponent = ComponentsHelper.initMyAppComponent(this);
    }
}
