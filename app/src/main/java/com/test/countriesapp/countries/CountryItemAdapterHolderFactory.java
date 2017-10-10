package com.test.countriesapp.countries;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sma on 10.10.17.
 */

public class CountryItemAdapterHolderFactory {

    @LayoutRes
    private int layoutId;
    private LayoutInflater layoutInflater;

    public CountryItemAdapterHolderFactory(int layoutId, LayoutInflater layoutInflater) {
        this.layoutId = layoutId;
        this.layoutInflater = layoutInflater;
    }

    public CountryItemAdapterHolder createViewHolder(ViewGroup parent) {
        final View view = layoutInflater.inflate(layoutId, parent, false);
        return new CountryItemAdapterHolder(view);
    }
}
