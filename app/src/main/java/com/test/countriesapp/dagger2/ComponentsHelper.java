package com.test.countriesapp.dagger2;

import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.app.ApiModule;
import com.test.countriesapp.dagger2.app.ContextModule;
import com.test.countriesapp.dagger2.app.DaggerMyAppComponent;
import com.test.countriesapp.dagger2.app.MainThreadModule;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.app.NavigationModule;
import com.test.countriesapp.dagger2.app.UtilsModule;

/**
 * Created by sma on 10.10.17.
 */

public class ComponentsHelper {

    private ComponentsHelper() {
    }

    public static MyAppComponent initMyAppComponent(MyApp myApplication) {
        final MyAppComponent component = DaggerMyAppComponent
                .builder()
                .contextModule(new ContextModule(myApplication))
                .apiModule(new ApiModule())
                .mainThreadModule(new MainThreadModule())
                .utilsModule(new UtilsModule())
                .navigationModule(new NavigationModule())
                .build();
        return component;
    }
}
