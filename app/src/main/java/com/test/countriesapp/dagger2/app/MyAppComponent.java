package com.test.countriesapp.dagger2.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;

import com.example.interfaces.IPostExecutionThread;
import com.example.sma.data.IApplicationApi;
import com.test.countriesapp.MainActivity;
import com.test.countriesapp.utils.image.IImageLoader;

import javax.inject.Singleton;

import dagger.Component;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

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

    IPostExecutionThread mainThread();

    IImageLoader imageLoader();

    SharedPreferences sharedPreferences();

    LayoutInflater layoutInflater();

    Router router();

    NavigatorHolder navigatorHolder();
}