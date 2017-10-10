package com.test.countriesapp.dagger2.app;

import android.content.Context;

import com.test.countriesapp.MyApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class ContextModule {

    private MyApp myApp;

    public ContextModule(MyApp myApp) {
        this.myApp = myApp;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return this.myApp;
    }
}
