package com.example;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public interface ICountryRepository {

    //  Flowable<List<UserDomainModel>> getUsers();
    Flowable<List<CountryDomainModel>> getCountries();
}
