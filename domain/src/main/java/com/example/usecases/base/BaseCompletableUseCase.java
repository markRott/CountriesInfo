package com.example.usecases.base;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.Completable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by sma on 05.11.17.
 */

public abstract class BaseCompletableUseCase<Params> extends BaseUseCase {

    public BaseCompletableUseCase(IPostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    abstract Completable buildCompletableUseCase(Params params);

    public void execute(final DisposableCompletableObserver completableObserver, final Params params) {
        final Completable completable = getCompletable(params);

        addDisposable(
                //
                completable.subscribeWith(completableObserver)
        );
    }

    private Completable getCompletable(final Params params) {
        return buildCompletableUseCase(params)
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread.getScheduler());
    }

}
