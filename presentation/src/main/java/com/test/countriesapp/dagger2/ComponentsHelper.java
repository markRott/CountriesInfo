package com.test.countriesapp.dagger2;

import com.example.models.CountryDomainModel;
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

    private static MyAppComponent appComponent;
    private static CountriesComponent countriesComponent;
    private static DetailCountryComponent detailCountryComponent;
    
    private ComponentsHelper() {
    }

    public static MyAppComponent initMyAppComponent(MyApp myApplication) {
        if (appComponent != null) return appComponent;
        appComponent = DaggerMyAppComponent
                .builder()
                .contextModule(new ContextModule(myApplication))
                .apiModule(new ApiModule())
                .mainThreadModule(new MainThreadModule())
                .utilsModule(new UtilsModule())
                .navigationModule(new NavigationModule())
                .cacheModule(new CacheModule())
                .lruCacheForCountryFlagsModule(new LruCacheForCountryFlagsModule())
                .build();

        return appComponent;
    }

    public static CountriesComponent initCountriesComponent() {
        if (countriesComponent != null) return countriesComponent;
        countriesComponent = DaggerCountriesComponent
                .builder()
                .myAppComponent(appComponent)
                .countriesAdapterModule(new CountriesAdapterModule())
                .countryRepositoryModule(new CountryRepositoryModule())
                .countriesUseCaseModule(new CountriesUseCaseModule())
                .build();
        return countriesComponent;
    }

    public static DetailCountryComponent initDetailCountryComponent(CountryDomainModel model) {
        if (detailCountryComponent != null) return detailCountryComponent;
        detailCountryComponent
                = DaggerDetailCountryComponent
                .builder()
                .myAppComponent(appComponent)
                .flagRepositoryModule(new FlagRepositoryModule(model))
                .flagUseCaseModule(new FlagUseCaseModule())
                .build();
        return detailCountryComponent;
    }

    public static void clearCountriesComponent() {
        if (countriesComponent != null) countriesComponent = null;
    }

    public static void clearDetailCountryComponent() {
        if (detailCountryComponent != null) detailCountryComponent = null;
    }

    public static MyAppComponent getAppComponent() {
        return appComponent;
    }

    public static CountriesComponent getCountriesComponent() {
        return countriesComponent;
    }

    public static DetailCountryComponent getDetailCountryComponent() {
        return detailCountryComponent;
    }
}
