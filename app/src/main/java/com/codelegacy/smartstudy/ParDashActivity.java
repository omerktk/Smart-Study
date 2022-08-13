package com.codelegacy.smartstudy;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class ParDashActivity extends AppCompatActivity {

    ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_dash);

        gif = findViewById(R.id.gif);
        Glide.with(ParDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);
    }
}