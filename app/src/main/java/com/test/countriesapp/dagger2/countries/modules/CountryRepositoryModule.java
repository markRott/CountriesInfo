package com.test.countriesapp.dagger2.countries.modules;

import com.example.interfaces.ICountryRepository;
import com.example.sma.data.IApplicationApi;
import com.example.sma.data.fetchdata.FetchCountriesDataImpl;
import com.example.sma.data.fetchdata.ICountriesFetchData;
import com.example.sma.data.mappers.ConvertCountryEntityToDomainModel;
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
    public ConvertCountryEntityToDomainModel provideMapper() {
        return new ConvertCountryEntityToDomainModel();
    }

    @Provides
    @CountriesScope
    public ICountriesFetchData provideFetchDada(IApplicationApi api) {
        return new FetchCountriesDataImpl(api);
    }

    @Provides
    @CountriesScope
    public ICountryRepository provideCountryRepository(
            ConvertCountryEntityToDomainModel mapper,
            ICountriesFetchData fetchData
    ) {

        return new CountriesRepositoryImpl(mapper, fetchData);
    }

}
