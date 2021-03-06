package com.example.sma.data.repositories.country;

import com.example.sma.data.IApplicationApi;
import com.example.sma.data.cache.realm.ICache;
import com.example.sma.data.fetchdata.country.FetchCountriesDataFromCacheImpl;
import com.example.sma.data.fetchdata.country.FetchCountriesDataFromNetworkImpl;
import com.example.sma.data.fetchdata.country.ICountriesDataProvider;

/**
 * Created by sma on 11.10.17.
 */

public class CountriesDataFactory {

    private final IApplicationApi api;
    private final ICache factoryRealmCache;

    public CountriesDataFactory(ICache realmCache, IApplicationApi api) {
        this.api = api;
        this.factoryRealmCache = realmCache;
    }

    public ICountriesDataProvider getDataProvider() {
        if (factoryRealmCache.isCached()) {
            return new FetchCountriesDataFromCacheImpl(factoryRealmCache);
        } else
            return new FetchCountriesDataFromNetworkImpl(factoryRealmCache, api);
    }

}
