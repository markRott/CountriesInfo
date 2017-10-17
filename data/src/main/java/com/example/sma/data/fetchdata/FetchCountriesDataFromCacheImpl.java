package com.example.sma.data.fetchdata;

import com.example.sma.data.cache.realm.ICache;
import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 11.10.17.
 */

public class FetchCountriesDataFromCacheImpl implements ICountriesDataProvider {

    private final ICache realmCache;

    public FetchCountriesDataFromCacheImpl(ICache realmCache) {
        this.realmCache = realmCache;
    }

    @Override
    public Flowable<List<CountryEntity>> countriesEntity() {
        return Flowable.just(realmCache.getCountries());
    }
}
