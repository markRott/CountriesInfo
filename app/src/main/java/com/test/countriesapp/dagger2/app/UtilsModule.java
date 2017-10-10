package com.test.countriesapp.dagger2.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;

import com.test.countriesapp.utils.image.IImageLoader;
import com.test.countriesapp.utils.image.PicassoImageLoaderImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class UtilsModule {

    @Singleton
    @Provides
    public IImageLoader provideImageLoader(Context context) {

        return new PicassoImageLoaderImpl(context);
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Context context) {

        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    LayoutInflater providesLayoutInflater(Context context) {
        return LayoutInflater.from(context);
    }

}
