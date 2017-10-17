package com.test.countriesapp.dagger2.countries.modules;

import com.example.interfaces.ICountryRepository;
import com.example.interfaces.IPostExecutionThread;
import com.example.usecases.CountriesUseCase;
import com.test.countriesapp.dagger2.countries.CountriesScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class CountriesUseCaseModule {

    @Provides
    @CountriesScope
    public CountriesUseCase provideCountriesUseCase(
            IPostExecutionThread thread,
            ICountryRepository countryRepository) {

        return new CountriesUseCase(thread, countryRepository);
    }
}
