package com.example.sma.data.repositories.countryflag;

import com.example.interfaces.ICountryFlagRepository;

import io.reactivex.Flowable;

/**
 * Created by sma on 18.10.17.
 */

public class CountryFlagRepositoryImpl implements ICountryFlagRepository {

    private final String flagUrl;
    private final FlagDataFactory flagDataFactory;

    public CountryFlagRepositoryImpl(String flagUrl, FlagDataFactory flagDataFactory) {
        this.flagUrl = flagUrl;
        this.flagDataFactory = flagDataFactory;
    }

    @Override
    public Flowable<byte[]> getCountryFlagByteArray() {

        return flagDataFactory.getFlagProvider().getFlagByteArray(flagUrl);
    }
}
