package com.test.countriesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.test.countriesapp.base.BaseActivity;
import com.test.countriesapp.base.IBackButtonListener;
import com.test.countriesapp.dagger2.ComponentsHelper;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Replace;

/**
 * Created by sma on 10.10.17.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);

        if (savedInstanceState == null) {
            ComponentsHelper.initCountriesComponent();
            navigator.applyCommand(new Replace(Const.ScreenKey.COUNTRIES, null));
        }
    }

    @Override
    public void inject() {
        ComponentsHelper.getAppComponent().inject(this);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frml_main_container);
        if (fragment != null && fragment instanceof IBackButtonListener
                && ((IBackButtonListener) fragment).onBackPressed()) {
            //
            return;

        } else {
            super.onBackPressed();
        }
    }

    private Navigator navigator = new
            SupportFragmentNavigator(getSupportFragmentManager(), R.id.frml_main_container) {

                @Override
                protected Fragment createFragment(String screenKey, Object data) {

                    return FragmentFactory.getFragmentByKey(screenKey, data);
                }

                @Override
                protected void showSystemMessage(String message) {
                }

                @Override
                protected void exit() {

                    finish();
                }

                @Override
                public void applyCommand(Command command) {
                    super.applyCommand(command);
                }
            };
}
