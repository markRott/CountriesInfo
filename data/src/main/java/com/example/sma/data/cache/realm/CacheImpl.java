package com.example.sma.data.cache.realm;

import com.example.sma.data.RealmHolder;
import com.example.sma.data.entities.CountryEntity;
import com.example.sma.data.mappers.CountryRealmModelToEntity;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

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
        final Realm realm = RealmHolder.getInstance().getRealm();
        final RealmResults<CountryEntityForRealm> resp = realm.where(CountryEntityForRealm.class).findAll();
        return resp != null && resp.size() > 0;
    }

    @Override
    public List<CountryEntity> getCountries() {
        final List<CountryEntityForRealm> list = Realm.getDefaultInstance()
                .where(CountryEntityForRealm.class).findAll();
        final List<CountryEntity> entityList = countryRealmModelToEntity.transform(list);
        return entityList;
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
