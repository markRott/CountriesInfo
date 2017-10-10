package com.example.sma.data.mappers;

import com.example.sma.data.cache.CountryEntityForRealm;
import com.example.sma.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sma on 11.10.17.
 */

public class CountryEntityToRealmConverter {

    public CountryEntityForRealm transform(CountryEntity entity) {
        CountryEntityForRealm model = null;
        if (entity != null) {
            model = new CountryEntityForRealm();
            model.setArea(entity.getArea());
            model.setFlag(entity.getFlag());
            model.setRegion(entity.getRegion());
            model.setPopulation(entity.getPopulation());
            model.setCapital(entity.getCapital());
            model.setName(entity.getName());
            model.setNumericCode(entity.getNumericCode());
//            model.setBorders(entity.getBorders());
        }
        return model;
    }

    public List<CountryEntityForRealm> transform(Collection<CountryEntity> countryEntityCollection) {
        final List<CountryEntityForRealm> countryEntityForRealms = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntityCollection) {
            final CountryEntityForRealm forRealm = transform(countryEntity);
            if (forRealm == null) continue;
            countryEntityForRealms.add(forRealm);
        }
        return countryEntityForRealms;
    }

}
