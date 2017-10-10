package com.test.countriesapp.dagger2.app;

import com.example.interfaces.IPostExecutionThread;
import com.test.countriesapp.utils.UiThreadImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class MainThreadModule {

    @Provides
    @Singleton
    public IPostExecutionThread providePostExecutionThread() {

        return new UiThreadImpl();
    }
}
