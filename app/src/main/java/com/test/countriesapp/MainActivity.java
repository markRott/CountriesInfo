package com.test.countriesapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.test.countriesapp.base.BaseActivity;

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
            getMyApp().initCountriesComponent();
            navigator.applyCommand(new Replace(Const.ScreenKey.COUNTRIES, null));
        }
    }

    @Override
    public void inject() {
        getMyAppComponent().inject(this);
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
//                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }

                @Override
                protected void exit() {

                    finish();
                }

                @Override
                public void applyCommand(Command command) {
                    super.applyCommand(command);
//                    updateScreenNames(command);
                }
            };
}
