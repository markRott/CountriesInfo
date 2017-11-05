package com.example.usecases;

import com.example.models.CountryDomainModel;
import com.example.interfaces.ICountryRepository;
import com.example.interfaces.IPostExecutionThread;
import com.example.usecases.base.BaseFlowableUseCase;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesUseCase extends BaseFlowableUseCase<List<CountryDomainModel>, Void> {

    private ICountryRepository countryRepository;

    public CountriesUseCase(IPostExecutionThread thread, ICountryRepository repository) {
        super(thread);
        this.countryRepository = repository;
    }

    /**
     * Do not need to call
     */
    @Override
    public Flowable<List<CountryDomainModel>> buildUseCaseObservable(Void emptyParams) {
        //
        return countryRepository.getCountries();
    }
}
