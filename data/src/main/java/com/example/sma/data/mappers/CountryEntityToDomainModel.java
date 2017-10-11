package com.example.sma.data.mappers;

import com.example.models.CountryDomainModel;
import com.example.sma.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by sma on 10.10.17.
 */

public class CountryEntityToDomainModel {

    public CountryDomainModel transform(CountryEntity entity) {
        CountryDomainModel model = null;
        if (entity != null) {
            model = new CountryDomainModel();
            model.setArea(entity.getArea());
            model.setFlag(entity.getFlag());
            model.setRegion(entity.getRegion());
            model.setPopulation(entity.getPopulation());
            model.setCapital(entity.getCapital());
            model.setCountryName(entity.getName());
            model.setNumericCode(entity.getNumericCode());
        }
        return model;
    }

    public List<CountryDomainModel> transform(Collection<CountryEntity> countryEntityCollection) {
        final List<CountryDomainModel> countryList = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntityCollection) {
            final CountryDomainModel user = transform(countryEntity);
            if (user == null) continue;
            countryList.add(user);
        }
        return countryList;
    }
}
