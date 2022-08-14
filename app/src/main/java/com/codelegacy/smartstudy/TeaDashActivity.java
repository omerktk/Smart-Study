package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;


public class TeaDashActivity extends AppCompatActivity {

    MaterialButton regstd,upsdata,sdata,mystd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_dash);
        regstd = (MaterialButton) findViewById(R.id.regstd);
        upsdata = (MaterialButton) findViewById(R.id.upsdata);
        sdata = (MaterialButton) findViewById(R.id.sdata);
        mystd = (MaterialButton) findViewById(R.id.mystd);

        regstd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),std_register.class));
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

    }
}