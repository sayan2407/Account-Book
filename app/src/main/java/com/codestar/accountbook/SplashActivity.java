package com.codestar.accountbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.Wave;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=3000;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar=(ProgressBar)findViewById(R.id.spinkit);

        Wave wave=new Wave();
        progressBar.setIndeterminateDrawable(wave);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}