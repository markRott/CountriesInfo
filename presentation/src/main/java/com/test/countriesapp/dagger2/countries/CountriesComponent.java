package com.test.countriesapp.dagger2.countries;

import com.example.interfaces.ICountryRepository;
import com.example.sma.data.cache.realm.ICache;
import com.example.sma.data.repositories.country.CountriesDataFactory;
import com.example.usecases.CountriesUseCase;
import com.test.countriesapp.countries.CountriesFragment;
import com.test.countriesapp.countries.CountriesPresenter;
import com.test.countriesapp.countries.adapter.CountriesAdapter;
import com.test.countriesapp.dagger2.app.MyAppComponent;
import com.test.countriesapp.dagger2.countries.modules.CountriesAdapterModule;
import com.test.countriesapp.dagger2.countries.modules.CountriesUseCaseModule;
import com.test.countriesapp.dagger2.countries.modules.CountryRepositoryModule;

import dagger.Component;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

@CountriesScope
@Component(dependencies = MyAppComponent.class,
        modules = {
                CountriesAdapterModule.class,
                CountryRepositoryModule.class,
                CountriesUseCaseModule.class
        })
public interface CountriesComponent {

    void inject(CountriesFragment countriesFragment);

    void inject(CountriesPresenter presenter);

    CountriesAdapter countriesAdapter();

    CountriesDataFactory countriesDataFactory();

    ICountryRepository countryRepository();

    CountriesUseCase countriesUseCase();

    Router router();

    ICache realmCache();
}
