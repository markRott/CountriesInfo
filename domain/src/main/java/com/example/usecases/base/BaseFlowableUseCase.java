package com.example.usecases.base;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseFlowableUseCase<T, Params> extends BaseUseCase {

    public BaseFlowableUseCase(IPostExecutionThread postExecutionThread) {
        super(postExecutionThread);
    }

    public abstract Flowable<T> buildUseCaseObservable(Params params);

    /**
     * Need call
     */
    public void execute(final DisposableSubscriber<T> disposableSubscriber, final Params params) {
        final Flowable<T> flowable = getFlowable(params);
        addDisposable(flowable.subscribeWith(disposableSubscriber));
    }

    private Flowable<T> getFlowable(final Params params) {
        return buildUseCaseObservable(params)
                .onBackpressureLatest()
                .subscribeOn(Schedulers.io())
                .observeOn(mainThread.getScheduler());
    }

}
