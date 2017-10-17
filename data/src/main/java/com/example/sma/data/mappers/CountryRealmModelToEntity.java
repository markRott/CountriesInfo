package com.example.sma.data.mappers;

import com.example.sma.data.cache.realm.CountryEntityForRealm;
import com.example.sma.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sma on 11.10.17.
 */

public class CountryRealmModelToEntity {

    public CountryEntity transform(CountryEntityForRealm entity) {
        CountryEntity model = null;
        if (entity != null) {
            model = new CountryEntity();
            model.setArea(entity.getArea());
            model.setFlag(entity.getFlag());
            model.setRegion(entity.getRegion());
            model.setPopulation(entity.getPopulation());
            model.setCapital(entity.getCapital());
            model.setName(entity.getName());
            model.setNumericCode(entity.getNumericCode());
        }
        return model;
    }

    public List<CountryEntity> transform(Collection<CountryEntityForRealm> realms) {
        final List<CountryEntity> entityList = new ArrayList<>();
        for (CountryEntityForRealm countryEntityForRealm : realms) {
            final CountryEntity entity = transform(countryEntityForRealm);
            if (entity == null) continue;
            entityList.add(entity);
        }
        return entityList;
    }

}
