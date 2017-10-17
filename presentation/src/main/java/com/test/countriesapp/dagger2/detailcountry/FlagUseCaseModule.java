package com.test.countriesapp.dagger2.detailcountry;

import com.example.interfaces.ICountryFlagRepository;
import com.example.interfaces.IPostExecutionThread;
import com.example.usecases.CountryFlagUseCase;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 18.10.17.
 */

@Module
public class FlagUseCaseModule {

    @Provides
    @DetailCountryScope
    public CountryFlagUseCase provideFlagUseCaseModule(
            IPostExecutionThread mainThread,
            ICountryFlagRepository repository) {

        return new CountryFlagUseCase(mainThread, repository);
    }
}
