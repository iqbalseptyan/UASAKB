package com.iqbalseptyan.uasakb.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.iqbalseptyan.uasakb.Activity.ViewPagerActivity;
import com.iqbalseptyan.uasakb.R;

/*
    NIM : 10116120
    NAMA : MOCHAMAD IQBAL SEPTYAN
    KELAS : IF-3
    TGL : 07-08-2019
*/
public class SplashScreenActivity extends AppCompatActivity {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        iv = (ImageView) findViewById(R.id.imageView);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.transition);
        iv.startAnimation(myanim);
        final Intent intent = new Intent(this, ViewPagerActivity.class);
        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
