//package com.example.sma.data.mappers;
//
//import com.example.models.CountryDomainModel;
//import com.example.sma.data.cache.CountryModelForRealm;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by sma on 11.10.17.
// */
//
//public class CountryRealmModelToDomain {
//
//    public CountryDomainModel transform(CountryModelForRealm entity) {
//
//        CountryDomainModel model = null;
//
//        if (entity != null) {
//            model = new CountryDomainModel();
//            model.setArea(entity.getArea());
//            model.setFlag(entity.getFlag());
//            model.setRegion(entity.getRegion());
//            model.setPopulation(entity.getPopulation());
//            model.setCapital(entity.getCapital());
//            model.setCountryName(entity.getCountryName());
//            model.setNumericCode(entity.getNumericCode());
////            model.setBorders(entity.getBorders());
//        }
//        return model;
//    }
//
//    public List<CountryDomainModel> transform(Collection<CountryModelForRealm> realms) {
//        final List<CountryDomainModel> countryList = new ArrayList<>();
//
//        for (CountryModelForRealm countryEntity : realms) {
//            final CountryDomainModel user = transform(countryEntity);
//            if (user == null) continue;
//            countryList.add(user);
//        }
//
//        return countryList;
//    }
//
//}
