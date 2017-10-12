package com.test.countriesapp.detailcountry;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.models.CountryDomainModel;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.Const;
import com.test.countriesapp.R;
import com.test.countriesapp.base.BaseFragment;
import com.test.countriesapp.utils.image.IImageLoader;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sma on 12.10.17.
 */

public class DetailCountryFragment extends BaseFragment {

    @BindView(R.id.iv_country_flag)
    ImageView ivCountryFlag;
    @BindView(R.id.tv_country_name)
    TextView tvCountryName;
    @BindView(R.id.tv_country_capital)
    TextView tvCapital;
    @BindView(R.id.tv_country_region)
    TextView tvCountryRegion;
    @BindView(R.id.tv_country_area)
    TextView tvCountryArea;
    @BindView(R.id.tv_country_population)
    TextView tvCountryPopulation;
    @BindView(R.id.tv_country_numeric_code)
    TextView tvCountryNumericCode;

    @Inject
    IImageLoader imageLoader;

    private CountryDomainModel model;

    public static DetailCountryFragment newInstance(CountryDomainModel model) {
        final DetailCountryFragment frg = new DetailCountryFragment();
        final Bundle args = new Bundle();
        args.putSerializable(Const.ArgsKey.COUNTRY_DETAIL, model);
        frg.setArguments(args);
        return frg;
    }

    @Override
    public void inject() {
        getMyApp().getAppComponent().inject(this);
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

        model = getModelFromArgs();
        Logger.d(model);

        final View view = inflater.inflate(R.layout.frg_detail_country, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fillViews();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void fillViews() {
        imageLoader.loadImage(model.getFlag(), ivCountryFlag, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        tvCountryName.setText(String.format(getString(R.string.country_name), model.getCountryName()));
        tvCapital.setText(String.format(getString(R.string.capital), model.getCapital()));
        tvCountryRegion.setText(String.format(getString(R.string.country_region), model.getRegion()));
        tvCountryArea.setText(String.format(getString(R.string.country_area), String.valueOf(model.getArea())));
        tvCountryPopulation.setText(String.format(getString(R.string.population), String.valueOf(model.getPopulation())));
        tvCountryNumericCode.setText(String.format(getString(R.string.numeric_code), model.getNumericCode()));
    }

}
