package com.example.sma.data.fetchdata;

import com.example.sma.data.IApplicationApi;
import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public class FetchCountriesDataImpl implements ICountriesFetchData {

    private final IApplicationApi api;

    public FetchCountriesDataImpl(IApplicationApi api) {
        this.api = api;
    }

    @Override
    public Flowable<List<CountryEntity>> countriesEntity() {

        return api.fetchAllCountries();
    }
}
