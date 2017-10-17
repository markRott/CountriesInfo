package com.example.sma.data.cache.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sma on 12.10.17.
 */

public class LruCacheForCountryFlagImpl extends LinkedHashMap<String, byte[]> {

    private final int maxCapacity;

    public LruCacheForCountryFlagImpl(final int maxEntries) {
        super(maxEntries, 0.75f, true);
        this.maxCapacity = maxEntries;
    }

    @Override
    protected boolean removeEldestEntry(final Map.Entry<String, byte[]> eldest) {
        return super.size() > maxCapacity;
    }

}
