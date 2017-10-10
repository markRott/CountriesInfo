package com.test.countriesapp.base;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

public class BaseActivity extends MvpAppCompatActivity {

    @Inject
    public Router router;
    @Inject
    public NavigatorHolder navigatorHolder;

}
