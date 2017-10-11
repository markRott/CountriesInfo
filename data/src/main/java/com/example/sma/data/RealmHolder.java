package com.example.sma.data;

import io.realm.Realm;

/**
 * Created by sma on 11.10.17.
 */

public class RealmHolder {

    private Realm realm;
    private static RealmHolder ourInstance;

    private RealmHolder() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmHolder getInstance() {
        if (ourInstance == null) {
            ourInstance = new RealmHolder();
        }
        return ourInstance;
    }

    public Realm getRealm() {
        return realm;
    }
}
