package com.example.sma.data.fetchdata;

import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public interface ICountriesDataProvider {

    Flowable<List<CountryEntity>> countriesEntity();
}
