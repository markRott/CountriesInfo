package com.example.sma.data.repositories;

import com.example.sma.data.IApplicationApi;
import com.example.sma.data.cache.ICache;
import com.example.sma.data.fetchdata.FetchCountriesDataFromCacheImpl;
import com.example.sma.data.fetchdata.FetchCountriesDataFromNetworkImpl;
import com.example.sma.data.fetchdata.ICountriesDataProvider;

/**
 * Created by sma on 11.10.17.
 */

public class CountriesDataFactory {

    private final ICache realmCache;
    private final IApplicationApi api;

    public CountriesDataFactory(ICache realmCache, IApplicationApi api) {
        this.realmCache = realmCache;
        this.api = api;
    }

    public ICountriesDataProvider getDataProvider() {
        if (realmCache.isCached()) {
            return new FetchCountriesDataFromCacheImpl(realmCache);
        }
        return new FetchCountriesDataFromNetworkImpl(realmCache, api);
    }

}
