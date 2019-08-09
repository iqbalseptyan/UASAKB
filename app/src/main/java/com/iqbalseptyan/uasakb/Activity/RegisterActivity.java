package com.iqbalseptyan.uasakb.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iqbalseptyan.uasakb.SharedPreferences.Preferences;
import com.iqbalseptyan.uasakb.R;

/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 08-08-2019
*/
public class RegisterActivity extends AppCompatActivity {
    EditText etnama, etemail,etusername, etpassword;
    Button btnSimpan, btnLogin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etnama = (EditText) findViewById(R.id.etNama);
        etemail = (EditText) findViewById(R.id.etEmail);
        etusername = (EditText) findViewById(R.id.etUsername);
        etpassword = (EditText) findViewById(R.id.etPassword);

        btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regis();
            }
        });
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void regis(){
        etnama.setError(null);
        etemail.setError(null);
        etusername.setError(null);
        etpassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        String nama = etnama.getText().toString();
        String email = etemail.getText().toString();
        String username = etusername.getText().toString();
        String password = etpassword.getText().toString();

        if (TextUtils.isEmpty(nama)){
            etnama.setError("This field is required");
            fokus = etnama;
            cancel = true;
        }

        if (TextUtils.isEmpty(nama)){
            etemail.setError("This field is required");
            fokus = etemail;
            cancel = true;
        }

        if (TextUtils.isEmpty(username)){
            etusername.setError("This field is required");
            fokus = etusername;
            cancel = true;
        }else if(cekUser(username)){
            etusername.setError("This Username is already exist");
            fokus = etusername;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            etpassword.setError("This field is required");
            fokus = etpassword;
            cancel = true;
        }

        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredNama(getBaseContext(),nama);
            Preferences.setRegisteredEmail(getBaseContext(),email);
            Preferences.setRegisteredUser(getBaseContext(),username);
            Preferences.setRegisteredPass(getBaseContext(),password);
            Intent login = new Intent(this, LoginActivity.class);
            startActivity(login);
            finish();
        }


    }

    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
