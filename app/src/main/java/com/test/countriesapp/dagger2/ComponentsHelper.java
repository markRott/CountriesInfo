package com.test.countriesapp.dagger2;

import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.app.ApiModule;
import com.test.countriesapp.dagger2.app.ContextModule;
import com.test.countriesapp.dagger2.app.DaggerMyAppComponent;
import com.test.countriesapp.dagger2.app.MainThreadModule;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.app.NavigationModule;
import com.test.countriesapp.dagger2.app.UtilsModule;
import com.test.countriesapp.dagger2.countries.CountriesComponent;
import com.test.countriesapp.dagger2.countries.DaggerCountriesComponent;
import com.test.countriesapp.dagger2.countries.modules.CountriesAdapterModule;
import com.test.countriesapp.dagger2.countries.modules.CountriesUseCaseModule;
import com.test.countriesapp.dagger2.countries.modules.CountryRepositoryModule;

/**
 * Created by sma on 10.10.17.
 */

public class ComponentsHelper {

    private static MyAppComponent myAppComponent;
    private static CountriesComponent countriesComponent;

    private ComponentsHelper() {
    }

    public static MyAppComponent initMyAppComponent(MyApp myApplication) {
        myAppComponent = DaggerMyAppComponent
                .builder()
                .contextModule(new ContextModule(myApplication))
                .apiModule(new ApiModule())
                .mainThreadModule(new MainThreadModule())
                .utilsModule(new UtilsModule())
                .navigationModule(new NavigationModule())
                .build();
        return myAppComponent;
    }

    public static CountriesComponent initCountriesComponent() {
        countriesComponent = DaggerCountriesComponent
                .builder()
                .myAppComponent(myAppComponent)
                .countriesAdapterModule(new CountriesAdapterModule())
                .countryRepositoryModule(new CountryRepositoryModule())
                .countriesUseCaseModule(new CountriesUseCaseModule())
                .build();
        return countriesComponent;
    }
}