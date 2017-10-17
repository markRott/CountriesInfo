package com.test.countriesapp.dagger2.detailcountry;

import com.example.interfaces.ICountryFlagRepository;
import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;
import com.example.sma.data.repositories.countryflag.CountryFlagRepositoryImpl;
import com.example.sma.data.repositories.countryflag.FlagDataFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 18.10.17.
 */

@Module
public class FlagRepositoryModule {

    private final String flagUrl;

    public FlagRepositoryModule(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    @Provides
    @DetailCountryScope
    public FlagDataFactory provideFlagDataFactory(LruCacheForCountryFlagImpl cache) {
        return new FlagDataFactory(flagUrl, cache);
    }

    @Provides
    @DetailCountryScope
    public ICountryFlagRepository provideCountryFlagRepository(FlagDataFactory flagDataFactory) {

        return new CountryFlagRepositoryImpl(flagUrl, flagDataFactory);
    }
}
