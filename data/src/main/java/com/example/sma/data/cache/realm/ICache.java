package com.example.sma.data.cache.realm;

import com.example.sma.data.entities.CountryEntity;

import java.util.List;

/**
 * Created by sma on 10.10.17.
 */

public interface ICache {

    boolean isCached();

    List<CountryEntity> getCountries();

    void put(List<CountryEntityForRealm> countryList);

}
