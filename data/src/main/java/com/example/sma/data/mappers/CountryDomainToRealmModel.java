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
//public class CountryDomainToRealmModel {
//
//    public CountryModelForRealm transform(CountryDomainModel model) {
//        if (model == null) return null;
//        CountryModelForRealm realmModel = new CountryModelForRealm();
//        realmModel.setCountryName(model.getCountryName());
//        realmModel.setArea(model.getArea());
//        realmModel.setFlag(model.getFlag());
//        realmModel.setRegion(model.getRegion());
//        realmModel.setPopulation(model.getPopulation());
//        realmModel.setCapital(model.getCapital());
//        realmModel.setNumericCode(model.getNumericCode());
////        realmModel.setBorders(model.getBorders());
//        return realmModel;
//    }
//
//    public List<CountryModelForRealm> transform(Collection<CountryDomainModel> domainModels) {
//
//        final List<CountryModelForRealm> realmList = new ArrayList<>();
//
//        for (CountryDomainModel domainModel : domainModels) {
//            final CountryModelForRealm realmModel = transform(domainModel);
//            if (realmModel == null) continue;
//            realmList.add(realmModel);
//        }
//        return realmList;
//    }
//
//}
