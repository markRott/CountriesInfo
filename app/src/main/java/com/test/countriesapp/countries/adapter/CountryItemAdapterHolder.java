package com.test.countriesapp.countries.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.test.countriesapp.R;

/**
 * Created by sma on 10.10.17.
 */

public class CountryItemAdapterHolder extends RecyclerView.ViewHolder {

    View rootView;
    TextView tvCountryName;

    public CountryItemAdapterHolder(View itemView) {
        super(itemView);
        rootView = itemView;
        tvCountryName = rootView.findViewById(R.id.tv_country_name);
    }
}
