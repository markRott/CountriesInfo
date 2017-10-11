package com.test.countriesapp.dagger2.countries.modules;

import com.example.sma.data.cache.CacheImpl;
import com.example.sma.data.cache.ICache;
import com.example.sma.data.mappers.CountryRealmModelToEntity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 11.10.17.
 */

@Module
public class CacheModule {

    @Provides
    @Singleton
    public CountryRealmModelToEntity provideCountryRealmModelToDomain() {

        return new CountryRealmModelToEntity();
    }

    @Provides
    @Singleton
    public ICache provideCache(CountryRealmModelToEntity countryRealmModelToEntity) {

        return new CacheImpl(countryRealmModelToEntity);
    }

}
