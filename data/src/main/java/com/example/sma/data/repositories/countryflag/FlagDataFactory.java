package com.example.sma.data.repositories.countryflag;

import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;
import com.example.sma.data.fetchdata.flag.FlagDataProviderFromCache;
import com.example.sma.data.fetchdata.flag.FlagDataProviderFromNetwork;
import com.example.sma.data.fetchdata.flag.IFlagDataProvider;

/**
 * Created by sma on 18.10.17.
 */

public class FlagDataFactory {

    private final String flagUrl;
    private final LruCacheForCountryFlagImpl lruCache;

    public FlagDataFactory(String flagUrl, LruCacheForCountryFlagImpl lruCache) {
        this.flagUrl = flagUrl;
        this.lruCache = lruCache;
    }

    public IFlagDataProvider getFlagProvider() {
        IFlagDataProvider dataProvider = null;
        if (lruCache != null && lruCache.containsKey(flagUrl)) {
            dataProvider = new FlagDataProviderFromCache(lruCache);
        } else {
            dataProvider = new FlagDataProviderFromNetwork(lruCache);
        }
        return dataProvider;
    }
}
