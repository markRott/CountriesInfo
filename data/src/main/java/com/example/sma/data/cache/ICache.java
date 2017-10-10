package com.example.sma.data.cache;

import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public interface ICache {

    boolean isCached();

    Flowable<List<CountryEntity>> getCountries();

    void put(List<CountryEntityForRealm> countryList);

}
