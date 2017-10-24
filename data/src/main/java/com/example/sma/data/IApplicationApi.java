package com.example.sma.data;

import com.example.sma.data.entities.CountryEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by sma on 10.10.17.
 */

public interface IApplicationApi {

    String SVG = ".svg";
    String BASE_URL = "https://restcountries.eu/";
    String BASE_URL_FOR_FLAG_IMAGE = "https://restcountries.eu/data/";

    //    @GET("http://www.mocky.io/v2/59ee79833300008339b5c917")
    @GET(BASE_URL + "rest/v2/all")
    Flowable<List<CountryEntity>> fetchAllCountries();
}
