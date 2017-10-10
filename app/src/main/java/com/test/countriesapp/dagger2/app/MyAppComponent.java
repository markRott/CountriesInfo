package com.test.countriesapp.dagger2.app;

import android.content.Context;

import com.example.sma.data.IApplicationApi;
import com.test.countriesapp.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sma on 10.10.17.
 */

@Singleton
@Component(modules = {
        ContextModule.class,
        ApiModule.class,
        MainThreadModule.class,
        UtilsModule.class,
        NavigationModule.class
})
public interface MyAppComponent {

    void inject(MainActivity mainActivity);

    Context context();

    IApplicationApi applicationApi();
}
