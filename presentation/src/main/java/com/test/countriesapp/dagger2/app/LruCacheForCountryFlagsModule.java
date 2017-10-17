package com.test.countriesapp.dagger2.app;

import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 12.10.17.
 */
@Module
public class LruCacheForCountryFlagsModule {

    @Provides
    @Singleton
    LruCacheForCountryFlagImpl provideLruCacheForCountryFlag() {

        return new LruCacheForCountryFlagImpl(50);
    }
}
