package com.iqbalseptyan.uasakb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.iqbalseptyan.uasakb.SharedPreferences.Preferences;
import com.iqbalseptyan.uasakb.R;


/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 08-08-2019
*/
public class LoginActivity extends AppCompatActivity {
    EditText etusername, etpassword;
    Button btnLogin;
    TextView btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etusername = (EditText) findViewById(R.id.etUsername);
        etpassword = (EditText) findViewById(R.id.etPassword);

        btnLogin = (Button) findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                etusername.setError(null);
                etpassword.setError(null);
                View focus = null;
                boolean cancel = false;

                String username = etusername.getText().toString();
                String password = etpassword.getText().toString();

                if (TextUtils.isEmpty(username)){
                    etusername.setError("This field is required");
                    focus = etusername;
                    cancel = true;
                }

                if (TextUtils.isEmpty(password)){
                    etpassword.setError("This field is required");
                    focus = etpassword;
                    cancel = true;
                }

                if (cancel) focus.requestFocus();
                else masuk();

            }
        });
        btnRegister = (TextView) findViewById(R.id.tldaftar);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }
    }

    private void masuk(){
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),MainActivity.class));
        finish();
    }



}

