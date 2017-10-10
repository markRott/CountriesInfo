package com.test.countriesapp.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.app.MyAppComponent;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    public Router router;
    @Inject
    public NavigatorHolder navigatorHolder;

    public abstract void inject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    public MyAppComponent getMyAppComponent() {
        return ((MyApp) getApplication()).getAppComponent();
    }
}
