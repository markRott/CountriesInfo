package com.test.countriesapp.dagger2.countries.modules;

import com.example.interfaces.ICountryRepository;
import com.example.sma.data.IApplicationApi;
import com.example.sma.data.cache.ICache;
import com.example.sma.data.mappers.CountryEntityToDomainModel;
import com.example.sma.data.repositories.CountriesDataFactory;
import com.example.sma.data.repositories.CountriesRepositoryImpl;
import com.test.countriesapp.dagger2.countries.CountriesScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class CountryRepositoryModule {

    @Provides
    @CountriesScope
    public CountryEntityToDomainModel provideMapper() {

        return new CountryEntityToDomainModel();
    }

    @Provides
    @CountriesScope
    public CountriesDataFactory provideCountriesDataFactory(ICache cache, IApplicationApi api) {

        return new CountriesDataFactory(cache, api);
    }

    @Provides
    @CountriesScope
    public ICountryRepository provideCountryRepository(
            CountryEntityToDomainModel mapper,
            CountriesDataFactory countriesDataFactory) {

        return new CountriesRepositoryImpl(mapper, countriesDataFactory);
    }
}
