package com.test.countriesapp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.test.countriesapp.dagger2.ComponentsHelper;

import io.realm.Realm;

/**
 * Created by sma on 10.10.17.
 */

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
        initRealm();
        initLeak();
        initAppComponent();
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
        ComponentsHelper.initMyAppComponent(this);
    }
}
