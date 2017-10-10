package com.test.countriesapp.utils;

import com.example.interfaces.IPostExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by sma on 10.10.17.
 */

public class UiThreadImpl implements IPostExecutionThread {

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
