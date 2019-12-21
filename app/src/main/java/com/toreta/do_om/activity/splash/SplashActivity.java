package com.toreta.do_om.activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.toreta.do_om.R;
import com.toreta.do_om.activity.MainActivity;
import com.toreta.do_om.activity.onboarding.OnboardingActivity;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottie = findViewById(R.id.lottie);

        SharedPreferences pref = getSharedPreferences("isFirst", Activity.MODE_PRIVATE);
        Boolean first = pref.getBoolean("isFirst", false);

        Handler handler = new Handler();
        handler.postDelayed(() -> {
            if (!first) {
                lottie.pauseAnimation();
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("isFirst", true);
                editor.apply();
                startActivity(new Intent(SplashActivity.this, OnboardingActivity.class));

            } else {
                lottie.playAnimation();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 3000);
    }
}
