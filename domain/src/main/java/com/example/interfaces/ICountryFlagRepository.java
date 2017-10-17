package com.example.interfaces;

import io.reactivex.Flowable;

/**
 * Created by sma on 18.10.17.
 */

public interface ICountryFlagRepository {

    Flowable<byte[]> getCountryFlagByteArray();
}
