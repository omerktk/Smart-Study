package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;


public class TeaDashActivity extends AppCompatActivity {
    ImageView gif;
    MaterialCardView regstd,upsdata,sdata,mystd,marks,addmarks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_dash);
        regstd = (MaterialCardView) findViewById(R.id.regstd);
        upsdata = (MaterialCardView) findViewById(R.id.upsdata);
        sdata = (MaterialCardView) findViewById(R.id.sdata);
        mystd = (MaterialCardView) findViewById(R.id.mystd);
        marks = (MaterialCardView) findViewById(R.id.mark60);
        addmarks = (MaterialCardView) findViewById(R.id.addmark60);

        gif = findViewById(R.id.gif);
        Glide.with(TeaDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);

        regstd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),StdRegActivity.class));
        });

        sdata.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataList.class));
        });

        mystd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudentList.class));
        });

        upsdata.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataUpload.class));
        });

        marks.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkList.class));
        });

        addmarks.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkDataUpload.class));
        });

    }
}