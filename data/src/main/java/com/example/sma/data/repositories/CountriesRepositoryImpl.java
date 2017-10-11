package com.example.sma.data.repositories;

import com.example.interfaces.ICountryRepository;
import com.example.models.CountryDomainModel;
import com.example.sma.data.entities.CountryEntity;
import com.example.sma.data.fetchdata.ICountriesDataProvider;
import com.example.sma.data.mappers.CountryEntityToDomainModel;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesRepositoryImpl implements ICountryRepository {

    private CountryEntityToDomainModel converter;
    private CountriesDataFactory dataFactory;

    public CountriesRepositoryImpl(
            CountryEntityToDomainModel mapper,
            CountriesDataFactory countriesDataFactory) {
        this.converter = mapper;
        this.dataFactory = countriesDataFactory;
    }

    @Override
    public Flowable<List<CountryDomainModel>> getCountries() {
        final ICountriesDataProvider provider = dataFactory.getDataProvider();
        final Flowable<List<CountryEntity>> flowableList = provider.countriesEntity();
        return flowableList.map(new MapOperator());
    }

    private class MapOperator implements Function<List<CountryEntity>, List<CountryDomainModel>> {
        @Override
        public List<CountryDomainModel> apply(@NonNull List<CountryEntity> countryEntities) throws Exception {
            return converter.transform(countryEntities);
        }
    }
}
