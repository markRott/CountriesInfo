package com.example.sma.data.repositories;

import com.example.interfaces.ICountryRepository;
import com.example.models.CountryDomainModel;
import com.example.sma.data.entities.CountryEntity;
import com.example.sma.data.fetchdata.ICountriesFetchData;
import com.example.sma.data.mappers.ConvertCountryEntityToDomainModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesRepositoryImpl implements ICountryRepository {

    private ICountriesFetchData countriesData;
    private ConvertCountryEntityToDomainModel converter;

    public CountriesRepositoryImpl(ConvertCountryEntityToDomainModel mapper, ICountriesFetchData data) {
        this.converter = mapper;
        this.countriesData = data;
    }

    @Override
    public Flowable<List<CountryDomainModel>> getCountries() {

        return countriesData.countriesEntity().map(new MapOperator());
    }

    private class MapOperator implements Function<List<CountryEntity>, List<CountryDomainModel>> {

        @Override
        public List<CountryDomainModel> apply(@NonNull List<CountryEntity> countryEntities) throws Exception {

            return converter.transform(countryEntities);
        }
    }
}
