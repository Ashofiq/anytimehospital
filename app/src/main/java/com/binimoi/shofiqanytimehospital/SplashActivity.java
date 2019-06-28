package com.binimoi.shofiqanytimehospital;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.binimoi.shofiqanytimehospital.SharedPrefManager.mCtx;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


       Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try {
                    sleep(5000);
                }catch (Exception e){ e.printStackTrace();}

                finally {
                    Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                    startActivity(i);
                }
            }
        };

        thread.start();
    }


    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }



}
