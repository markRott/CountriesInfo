package com.example.sma.data.cache;

import com.example.sma.data.entities.CountryEntity;
import com.example.sma.data.mappers.CountryRealmModelToEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.realm.Realm;

/**
 * Created by sma on 10.10.17.
 */

public class CacheImpl implements ICache {

    private final CountryRealmModelToEntity countryRealmModelToEntity;

    public CacheImpl(CountryRealmModelToEntity countryRealmModelToEntity) {
        this.countryRealmModelToEntity = countryRealmModelToEntity;
    }

    @Override
    public boolean isCached() {
        final Realm realm = Realm.getDefaultInstance();
        final boolean flag = realm
                .where(CountryEntityForRealm.class).findAll() != null &&
                realm.where(CountryEntityForRealm.class).findAll().size() > 0;

        return flag;
    }

    @Override
    public Flowable<List<CountryEntity>> getCountries() {
        final List<CountryEntityForRealm> list = Realm.getDefaultInstance()
                .where(CountryEntityForRealm.class).findAll();
        final List<CountryEntity> entityList = countryRealmModelToEntity.transform(list);
        return Flowable.just(entityList);
    }

    @Override
    public void put(List<CountryEntityForRealm> countryList) {
        final Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(countryList);
        realm.commitTransaction();
        realm.close();
    }
}
