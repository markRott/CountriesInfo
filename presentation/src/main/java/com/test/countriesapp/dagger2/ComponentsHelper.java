package com.test.countriesapp.dagger2;

import com.test.countriesapp.MyApp;
import com.test.countriesapp.dagger2.app.ApiModule;
import com.test.countriesapp.dagger2.app.ContextModule;
import com.test.countriesapp.dagger2.app.DaggerMyAppComponent;
import com.test.countriesapp.dagger2.app.LruCacheForCountryFlagsModule;
import com.test.countriesapp.dagger2.app.MainThreadModule;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.app.NavigationModule;
import com.test.countriesapp.dagger2.app.UtilsModule;
import com.test.countriesapp.dagger2.countries.CountriesComponent;
import com.test.countriesapp.dagger2.countries.DaggerCountriesComponent;
import com.test.countriesapp.dagger2.countries.modules.CacheModule;
import com.test.countriesapp.dagger2.countries.modules.CountriesAdapterModule;
import com.test.countriesapp.dagger2.countries.modules.CountriesUseCaseModule;
import com.test.countriesapp.dagger2.countries.modules.CountryRepositoryModule;
import com.test.countriesapp.dagger2.detailcountry.DaggerDetailCountryComponent;
import com.test.countriesapp.dagger2.detailcountry.DetailCountryComponent;
import com.test.countriesapp.dagger2.detailcountry.FlagRepositoryModule;
import com.test.countriesapp.dagger2.detailcountry.FlagUseCaseModule;

/**
 * Created by sma on 10.10.17.
 */

public class ComponentsHelper {

    private ComponentsHelper() {
    }

    public static MyAppComponent initMyAppComponent(MyApp myApplication) {
        return DaggerMyAppComponent
                .builder()
                .contextModule(new ContextModule(myApplication))
                .apiModule(new ApiModule())
                .mainThreadModule(new MainThreadModule())
                .utilsModule(new UtilsModule())
                .navigationModule(new NavigationModule())
                .cacheModule(new CacheModule())
                .lruCacheForCountryFlagsModule(new LruCacheForCountryFlagsModule())
                .build();
    }

    public static CountriesComponent initCountriesComponent(MyAppComponent myAppComponent) {
        return DaggerCountriesComponent
                .builder()
                .myAppComponent(myAppComponent)
                .countriesAdapterModule(new CountriesAdapterModule())
                .countryRepositoryModule(new CountryRepositoryModule())
                .countriesUseCaseModule(new CountriesUseCaseModule())
                .build();
    }

    public static DetailCountryComponent initDetailCountryComponent(
            MyAppComponent myAppComponent,
            String flagUrl) {

        return DaggerDetailCountryComponent
                .builder()
                .myAppComponent(myAppComponent)
                .flagRepositoryModule(new FlagRepositoryModule(flagUrl))
                .flagUseCaseModule(new FlagUseCaseModule())
                .build();
    }
}
