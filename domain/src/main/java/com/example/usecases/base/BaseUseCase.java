package com.example.usecases.base;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by sma on 05.11.17.
 */

public abstract class BaseUseCase {

    protected IPostExecutionThread mainThread;
    protected CompositeDisposable compositeDisposable;

    public BaseUseCase(IPostExecutionThread postExecutionThread) {
        this.mainThread = postExecutionThread;
        compositeDisposable = new CompositeDisposable();
    }

    public void dispose() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        compositeDisposable.add(localDisposable);
    }
}
