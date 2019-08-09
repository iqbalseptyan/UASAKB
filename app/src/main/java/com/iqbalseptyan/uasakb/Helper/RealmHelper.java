package com.iqbalseptyan.uasakb.Helper;

import android.util.Log;

import com.iqbalseptyan.uasakb.Model.TemanModel;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 09-08-2019
*/
public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // To save data into database
    public void save(final TemanModel temanModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Membuat Database", "Berhasil membuat database!");
                    Number currentIdNum = realm.where(TemanModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    temanModel.setId(nextId);
                    TemanModel model = realm.copyToRealm(temanModel);
                }else{
                    Log.e("dbs", "Database tidak ada!");
                }
            }
        });
    }

    // TO get all data from database
    public List<TemanModel> getAllMahasiswa(){
        RealmResults<TemanModel> results = realm.where(TemanModel.class).findAll();
        return results;
    }

    // To update data from database
    public void update(final Integer id, final String nim, final String nama, final String kelas, final String telepon
            , final String email, final String medsos){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TemanModel model = realm.where(TemanModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
                model.setKelas(kelas);
                model.setTelepon(telepon);
                model.setEmail(email);
                model.setMedsos(medsos);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("dbs", "Berhasil mengubah data!");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    public void delete(Integer id){
        final RealmResults<TemanModel> model = realm.where(TemanModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}
