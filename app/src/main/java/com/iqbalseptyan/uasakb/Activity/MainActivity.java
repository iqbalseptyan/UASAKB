package com.iqbalseptyan.uasakb.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.iqbalseptyan.uasakb.Fragment.Kontak;
import com.iqbalseptyan.uasakb.Fragment.Logout;
import com.iqbalseptyan.uasakb.Fragment.Profil;
import com.iqbalseptyan.uasakb.Fragment.Teman;
import com.iqbalseptyan.uasakb.SharedPreferences.Preferences;
import com.iqbalseptyan.uasakb.R;


/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 07-08-2019
*/
public class MainActivity extends AppCompatActivity  {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.lfragment, new Profil()).commit();
        }

        View header = nvDrawer.getHeaderView(0);

        TextView lblName = (TextView) header.findViewById(R.id.txtnama);
        TextView lblEmail = (TextView) header.findViewById(R.id.txtemail);

        lblName.setText(Preferences.getRegisteredNama(getBaseContext()));
        lblEmail.setText(Preferences.getRegisteredEmail(getBaseContext()));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer (MenuItem menuItem){
        Fragment fragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.mp:
                fragmentClass = Profil.class;
                break;
            case R.id.mt:
                fragmentClass = Teman.class;
                break;
            case R.id.mk:
                fragmentClass = Kontak.class;
                break;
            case R.id.ml:
                fragmentClass = Logout.class;
                break;

            default:
                fragmentClass = Profil.class;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.lfragment, fragment).commit();
        setTitle(menuItem.getTitle());
        drawerLayout.closeDrawers();
    }
    private void setupDrawerContent (NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }
}
