package com.test.countriesapp.base;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by sma on 10.10.17.
 */

public abstract class BaseFragment extends MvpAppCompatFragment {

    public abstract void inject();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    public <T> T getModelFromArgs(final String key) {
        final Bundle bundle = getArguments();
        if (bundle == null) return null;
        return (T) bundle.getSerializable(key);
    }

}
