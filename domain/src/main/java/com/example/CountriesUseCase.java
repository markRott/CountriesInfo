package com.example;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesUseCase extends BaseUseCase<List<CountryDomainModel>, Void> {

    private ICountryRepository countryRepository;

    public CountriesUseCase(IPostExecutionThread thread, ICountryRepository repository) {
        super(thread);
        this.countryRepository = repository;
    }

    @Override
    public Flowable<List<CountryDomainModel>> buildUseCaseObservable(Void emptyParams) {
        Flowable<List<CountryDomainModel>> countriesFlowable = countryRepository.getCountries();
        return countriesFlowable;
    }
}
