package com.example.interfaces;

import com.example.models.CountryDomainModel;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public interface ICountryRepository {

    Flowable<List<CountryDomainModel>> getCountries();
}
