package com.iqbalseptyan.uasakb.Database;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 09-08-2019
*/
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
