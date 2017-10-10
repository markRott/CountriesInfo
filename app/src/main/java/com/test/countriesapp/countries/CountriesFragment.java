package com.test.countriesapp.countries;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.models.CountryDomainModel;
import com.test.countriesapp.CollectionsUtil;
import com.test.countriesapp.R;
import com.test.countriesapp.base.BaseDividerItemDecoration;
import com.test.countriesapp.base.BaseFragment;
import com.test.countriesapp.base.IRecyclerItemTouchListener;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.test.countriesapp.base.BaseDividerItemDecoration.VERTICAL_LIST;

/**
 * Created by sma on 10.10.17.
 */

public class CountriesFragment extends BaseFragment
        implements ICountriesView, IRecyclerItemTouchListener<CountryDomainModel> {

    @BindView(R.id.prb_countries)
    ProgressBar pbCountries;
    @BindView(R.id.rcv_countries)
    RecyclerView rcvCountries;
    @BindView(R.id.tv_error_msg)
    TextView tvErrorMessage;

    @Inject
    CountriesAdapter countriesAdapter;
    @InjectPresenter
    CountriesPresenter countriesPresenter;

    public static CountriesFragment newInstance() {
        return new CountriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.frg_countries, container, false);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setDataForPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        rcvCountries.setAdapter(null);
    }

    @Override
    public void showProgressBar() {
        pbCountries.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pbCountries.setVisibility(View.GONE);
    }

    @Override
    public void showErrorMessage(final String errorMsg) {
        tvErrorMessage.setVisibility(View.VISIBLE);
        tvErrorMessage.setText(errorMsg);
    }

    @Override
    public void hideErrorMessage() {
        tvErrorMessage.setVisibility(View.GONE);
    }

    @Override
    public void renderCountriesList(Collection<CountryDomainModel> countryList) {
        if (CollectionsUtil.isNullOrEmpty(countryList)) return;
        countriesAdapter.setData(new ArrayList<>(countryList));
        countriesAdapter.setItemTouchListener(this);
    }

    @Override
    public void onTouch(int position, CountryDomainModel data) {
//        usersPresenter.onOpenDetailScreen(data.getUserId());
    }

    private void setupRecyclerView() {
        rcvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvCountries.addItemDecoration(new BaseDividerItemDecoration(getContext(), VERTICAL_LIST));
        rcvCountries.setAdapter(countriesAdapter);
    }
}
