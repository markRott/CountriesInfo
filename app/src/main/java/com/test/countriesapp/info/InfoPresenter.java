package com.test.countriesapp.info;

import com.arellomobile.mvp.InjectViewState;
import com.example.sma.data.RealmHolder;
import com.example.sma.data.cache.CountryEntityForRealm;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.base.BasePresenter;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by sma on 10.10.17.
 */

@InjectViewState
public class InfoPresenter extends BasePresenter<IInfoView> {

    public void clearCache() {
        final Realm realm = RealmHolder.getInstance().getRealm();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm localRealm) {
                tryDeleteDataFromDatabase(localRealm);
            }
        });
    }

    private void tryDeleteDataFromDatabase(Realm localRealm) {
        try {
            final RealmResults<CountryEntityForRealm> result = localRealm.where(CountryEntityForRealm.class).findAll();
            final boolean state = result.deleteAllFromRealm();
            Logger.d("deleteAllFromRealm = %s", state);
            getViewState().showClearDatabaseMessage(state);
        } catch (Exception ex) {
            Logger.d("tryDeleteDataFromDatabase exception = %s ", ex.getMessage());
        }
    }
}
