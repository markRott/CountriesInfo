package com.test.countriesapp.info;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.test.countriesapp.MainActivity;
import com.test.countriesapp.R;
import com.test.countriesapp.base.BaseActivity;
import com.test.countriesapp.utils.ToastFactory;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InfoActivity extends BaseActivity implements IInfoView {

    @InjectPresenter
    InfoPresenter infoPresenter;

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

    @OnClick(R.id.btn_clear_cache)
    public void clickOnClearCache() {
        infoPresenter.clearCache();
    }

    @Override
    public void showClearDatabaseMessage(boolean deleteState) {
        if (deleteState) {
            ToastFactory.showToast(this, getString(R.string.msg_clear_cash));
        } else {
            ToastFactory.showToast(this, getString(R.string.msg_cache_is_empty));
        }
    }
}
