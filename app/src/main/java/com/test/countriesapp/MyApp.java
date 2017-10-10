package com.test.countriesapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.test.countriesapp.dagger2.ComponentsHelper;
import com.test.countriesapp.dagger2.app.MyAppComponent;

/**
 * Created by sma on 10.10.17.
 */

public class MyApp extends Application {

    private MyAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initLeack();
        initAppComponent();
    }

    private void initLeack() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }

    public MyAppComponent getAppComponent() {
        return appComponent;
    }

    private void initAppComponent(){
        appComponent = ComponentsHelper.initMyAppComponent(this);
    }
}
