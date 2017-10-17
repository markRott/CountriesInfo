package com.test.countriesapp.dagger2.countries.modules;

import android.content.Context;
import android.view.LayoutInflater;

import com.test.countriesapp.R;
import com.test.countriesapp.countries.adapter.CountriesAdapter;
import com.test.countriesapp.countries.adapter.CountryItemAdapterHolderFactory;
import com.test.countriesapp.dagger2.countries.CountriesScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sma on 10.10.17.
 */

@Module
public class CountriesAdapterModule {

    @Provides
    @CountriesScope
    public CountryItemAdapterHolderFactory provideUserViewHolderFactory(LayoutInflater layoutInflater) {
        return new CountryItemAdapterHolderFactory(R.layout.item_country, layoutInflater);
    }

    @Provides
    @CountriesScope
    public CountriesAdapter provideSocialNetworkAdapter(
            Context context,
            CountryItemAdapterHolderFactory factory) {

        return new CountriesAdapter(context, factory);
    }
}
