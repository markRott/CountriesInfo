package com.example.usecases.base;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.Single;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sma on 05.11.17.
 */

public abstract class BaseSingleUseCase<T, Params> extends BaseUseCase {

    public BaseSingleUseCase(IPostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    abstract Single<T> buildSingleUseCase(Params params);


    public void execute(final DisposableSingleObserver<T> singleObserver, final Params params) {
        final Single<T> single = getSingle(params);
        addDisposable(single.subscribeWith(singleObserver));
    }

    private Single<T> getSingle(final Params params) {
        return buildSingleUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread.getScheduler());
    }
}
