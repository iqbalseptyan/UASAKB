package com.iqbalseptyan.uasakb.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iqbalseptyan.uasakb.Helper.RealmHelper;
import com.iqbalseptyan.uasakb.Model.TemanModel;
import com.iqbalseptyan.uasakb.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 09-08-2019
*/
public class TambahTemanActivity extends AppCompatActivity {

    Button btnSimpan, btnTampil;
    EditText nim, nama, kelas, telepon, email, medsos;
    String sNama, sNim, sKelas, sTelepon, sEmail, sMedsos;
    Realm realm;
    RealmHelper realmHelper;
    TemanModel temanModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambahteman);
        this.setFinishOnTouchOutside(false);

        //Inisialisasi
        btnSimpan = findViewById(R.id.btnSubmit);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);
        kelas = findViewById(R.id.kelas);
        telepon = findViewById(R.id.telepon);
        email = findViewById(R.id.email);
        medsos = findViewById(R.id.medsos);

        //Set up Realm
        Realm.init(TambahTemanActivity.this);
        //clear alldata
        //.deleteRealmIfMigrationNeeded()
        RealmConfiguration configuration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sNim = nim.getText().toString();
                sNama = nama.getText().toString();
                sKelas = kelas.getText().toString();
                sTelepon = telepon.getText().toString();
                sEmail = email.getText().toString();
                sMedsos = medsos.getText().toString();

                if (!sNim.equals("") && !sNama.isEmpty()){
                    temanModel = new TemanModel();
                    temanModel.setNim(sNim);
                    temanModel.setNama(sNama);
                    temanModel.setKelas(sKelas);
                    temanModel.setTelepon(sTelepon);
                    temanModel.setEmail(sEmail);
                    temanModel.setMedsos(sMedsos);

                    realmHelper = new RealmHelper(realm);
                    realmHelper.save(temanModel);

                    Toast.makeText(TambahTemanActivity.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                    nim.setText("");
                    nama.setText("");
                    kelas.setText("");
                    telepon.setText("");
                    email.setText("");
                    medsos.setText("");
                }else {
                    Toast.makeText(TambahTemanActivity.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTampil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
