package com.example.sma.data.fetchdata.flag;

import com.example.sma.data.cache.lru.LruCacheForCountryFlagImpl;

import io.reactivex.Flowable;

/**
 * Created by sma on 18.10.17.
 */

public class FlagDataProviderFromCache implements IFlagDataProvider {

    private final LruCacheForCountryFlagImpl lruCache;

    public FlagDataProviderFromCache(LruCacheForCountryFlagImpl lruCache) {
        this.lruCache = lruCache;
    }

    @Override
    public Flowable<byte[]> getFlagByteArray(String flagUrl) {

        return Flowable.just(lruCache.get(flagUrl));
    }
}
