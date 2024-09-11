package com.example.danvantd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.danvantd.Presentation.News_Demo.Home_Demo_Acti;

public class SplashTheme extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashTheme.this, Home_Demo_Acti.class));
                finish();
            }
        },3000);
    }
}
