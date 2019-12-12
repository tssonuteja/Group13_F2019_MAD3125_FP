package com.example.group13_f2019_mad3125_fp.activities;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.group13_f2019_mad3125_fp.Preference;
import com.example.group13_f2019_mad3125_fp.R;

public class SplashActivity extends AppCompatActivity {

    Preference preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preference = new Preference(this);

        delayedStart();
    }

    private void delayedStart() {
        int TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                if (preference.getBoolean("isLoggedIn")) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } else {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, TIME_OUT);
    }
}