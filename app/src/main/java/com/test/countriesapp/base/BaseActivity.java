package com.test.countriesapp.base;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

/**
 * Created by sma on 10.10.17.
 */

public class BaseActivity extends MvpAppCompatActivity {

    @Inject
    public Router router;
    @Inject
    public NavigatorHolder navigatorHolder;

//    @Override
//    protected void onResumeFragments() {
//        super.onResumeFragments();
//        navigatorHolder.setNavigator(navigator);
//    }
//
//    @Override
//    protected void onPause() {
//        navigatorHolder.removeNavigator();
//        super.onPause();
//    }
//
//    private Navigator navigator = new
//            SupportFragmentNavigator(getSupportFragmentManager(), R.id.frm_main_container) {
//
//                @Override
//                protected Fragment createFragment(String screenKey, Object data) {
//
////                    return FragmentFactory.getFragmentByKey(screenKey, data);
//                    return null;
//                }
//
//                @Override
//                protected void showSystemMessage(String message) {
////                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                protected void exit() {
//
//                    finish();
//                }
//
//                @Override
//                public void applyCommand(Command command) {
//                    super.applyCommand(command);
////                    updateScreenNames(command);
//                }
//            };
}
