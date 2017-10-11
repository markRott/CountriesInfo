package com.example.sma.data.fetchdata;

import com.example.sma.data.IApplicationApi;
import com.example.sma.data.cache.CountryEntityForRealm;
import com.example.sma.data.cache.ICache;
import com.example.sma.data.entities.CountryEntity;
import com.example.sma.data.mappers.CountryEntityToRealmConverter;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by sma on 10.10.17.
 */

public class FetchCountriesDataFromNetworkImpl implements ICountriesDataProvider {

    private final ICache providerRealmCache;
    private final IApplicationApi api;

    public FetchCountriesDataFromNetworkImpl(ICache realmCache, IApplicationApi api) {
        this.api = api;
        this.providerRealmCache = realmCache;
    }

    @Override
    public Flowable<List<CountryEntity>> countriesEntity() {
        return api
                .fetchAllCountries()
                .doOnNext(new SaveInDatabaseImp());
    }

    private class SaveInDatabaseImp implements Consumer<List<CountryEntity>> {
        @Override
        public void accept(List<CountryEntity> countryEntities) throws Exception {
            final CountryEntityToRealmConverter mapper = new CountryEntityToRealmConverter();
            final List<CountryEntityForRealm> realmList = mapper.transform(countryEntities);
            providerRealmCache.put(realmList);
        }
    }
}
