package com.test.countriesapp.info;

import com.arellomobile.mvp.InjectViewState;
import com.example.sma.data.RealmHolder;
import com.example.sma.data.cache.realm.CountryEntityForRealm;
import com.orhanobut.logger.Logger;
import com.test.countriesapp.base.BasePresenter;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by sma on 10.10.17.
 */

@InjectViewState
public class InfoPresenter extends BasePresenter<IInfoView> {

    private boolean removeState = false;

    @Override
    public void destroy() {
    }

    public void clearData() {
        final Realm realm = RealmHolder.getInstance().getRealm();
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm localRealm) {
                tryDeleteDataFromDatabase(localRealm);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                getViewState().showClearDatabaseMessage(removeState);
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Logger.d("clearData ", error.getMessage());
            }
        });
    }

    private void tryDeleteDataFromDatabase(Realm localRealm) {
        try {
            final RealmResults<CountryEntityForRealm> result =
                    localRealm.where(CountryEntityForRealm.class).findAll();
            removeState = result.deleteAllFromRealm();
        } catch (Exception ex) {
            Logger.d("tryDeleteDataFromDatabase exception = %s ", ex.getMessage());
        }
    }
}
