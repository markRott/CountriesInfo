package com.example.usecases;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseUseCase<T, Params> {

    private CompositeDisposable disposables;
    private IPostExecutionThread postExecutionThread;

    public abstract Flowable<T> buildUseCaseObservable(Params params);

    public BaseUseCase(IPostExecutionThread thread) {
        this.postExecutionThread = thread;
        disposables = new CompositeDisposable();
    }

    public void execute(final DisposableSubscriber<T> disposableSubscriber, final Params params) {
        final Flowable<T> responseFlowable = getResponseFlowable(params);
        addDisposable(responseFlowable.subscribeWith(disposableSubscriber));
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        disposables.add(localDisposable);
    }

    private Flowable<T> getResponseFlowable(final Params params) {
        return buildUseCaseObservable(params)
                .subscribeOn(Schedulers.io())
                .observeOn(postExecutionThread.getScheduler());
    }

}
