package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView splashscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashscreen = findViewById(R.id.splashscreen);
        Glide.with(MainActivity.this).load(getDrawable(R.drawable.ab66)).into(splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent x = new Intent(MainActivity.this,AuthActivity.class);
                startActivity(x);
                finish();
            }
        },4500);
    }
}