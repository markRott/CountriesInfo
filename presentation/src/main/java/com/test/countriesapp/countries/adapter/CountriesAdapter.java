package com.test.countriesapp.countries.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.models.CountryDomainModel;
import com.test.countriesapp.base.BaseRecyclerAdapter;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesAdapter extends BaseRecyclerAdapter<CountryDomainModel, CountryItemAdapterHolder> {

    private CountryItemAdapterHolderFactory viewHolderFactory;

    public CountriesAdapter(Context context, CountryItemAdapterHolderFactory factory) {
        super(context);
        this.viewHolderFactory = factory;
    }

    @Override
    public CountryItemAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderFactory.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(CountryItemAdapterHolder holder, int position) {

        fillData(holder, position);
    }

    private void fillData(CountryItemAdapterHolder holder, int position) {
        final CountryDomainModel model = getItemByPosition(position);
        holder.tvCountryName.setText(model.getCountryName());
        setupItemTouchListener(holder.rootView, position, model);
    }

    public void removeTochListener(){
        setupItemTouchListener(null, 0, null);
    }
}
