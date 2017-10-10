package com.test.countriesapp.dagger2.countries.modules;

import com.example.sma.data.cache.CacheImpl;
import com.example.sma.data.cache.ICache;
import com.example.sma.data.mappers.CountryRealmModelToEntity;
import com.test.countriesapp.dagger2.countries.CountriesScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 11.10.17.
 */

@Module
public class CacheModule {

    @Provides
    @CountriesScope
    public CountryRealmModelToEntity provideCountryRealmModelToDomain() {
        return new CountryRealmModelToEntity();
    }

    @Provides
    @CountriesScope
    public ICache provideCache(CountryRealmModelToEntity countryRealmModelToEntity) {

        return new CacheImpl(countryRealmModelToEntity);
    }

}
