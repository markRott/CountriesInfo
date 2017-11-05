package com.example.usecases;

import com.example.interfaces.ICountryFlagRepository;
import com.example.interfaces.IPostExecutionThread;
import com.example.usecases.base.BaseFlowableUseCase;

import io.reactivex.Flowable;

/**
 * Created by sma on 17.10.17.
 */

public class CountryFlagUseCase extends BaseFlowableUseCase<byte[], Void> {

    private final ICountryFlagRepository repository;

    public CountryFlagUseCase(IPostExecutionThread thread, ICountryFlagRepository repository) {
        super(thread);
        this.repository = repository;
    }

    /**
     * Do not need to call
     */
    @Override
    public Flowable<byte[]> buildUseCaseObservable(Void aVoid) {

        return repository.getCountryFlagByteArray();
    }
}
