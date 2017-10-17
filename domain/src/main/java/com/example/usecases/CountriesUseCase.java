package com.example.usecases;

import com.example.models.CountryDomainModel;
import com.example.interfaces.ICountryRepository;
import com.example.interfaces.IPostExecutionThread;

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
    Flowable<List<CountryDomainModel>> buildUseCaseObservable(Void emptyParams) {
        final Flowable<List<CountryDomainModel>> countriesFlowable = countryRepository.getCountries();
        return countriesFlowable;
    }
}
