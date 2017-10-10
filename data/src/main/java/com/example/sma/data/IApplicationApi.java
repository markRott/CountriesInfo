package com.example.sma.data;

import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by sma on 10.10.17.
 */

public interface IApplicationApi {

    String BASE_URL = "https://restcountries.eu/rest/v2/";

    @GET(BASE_URL + "all")
    Flowable<List<CountryEntity>> fetchAllCountries();

}
