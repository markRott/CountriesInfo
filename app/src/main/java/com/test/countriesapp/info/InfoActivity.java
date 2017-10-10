package com.test.countriesapp.info;

import android.content.Intent;
import android.os.Bundle;

import com.test.countriesapp.MainActivity;
import com.test.countriesapp.R;
import com.test.countriesapp.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends BaseActivity implements IInfoView {

//    @InjectPresenter
//    InfoPresenter infoPresenter;

    @Override
    public void inject() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_load_countries)
    public void openCountriesScreen() {
        final Intent countriesScreen = new Intent(this, MainActivity.class);
        startActivity(countriesScreen);
    }

    @Override
    public void clearDatabase() {

    }
}
