package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class StdDashActivity extends AppCompatActivity {
    MaterialCardView btn,btn2;
    ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_dash);

        btn = (MaterialCardView) findViewById(R.id.cls);
        btn2 = (MaterialCardView) findViewById(R.id.sdr);
        gif = findViewById(R.id.gif);
        Glide.with(StdDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);
        //class days
        btn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataList.class));
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkList2.class));
        });
        //Study Data

    }
}