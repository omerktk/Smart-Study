package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;

public class StdDashActivity extends AppCompatActivity {
    MaterialButton btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_dash);

        btn = (MaterialButton) findViewById(R.id.cls);
        btn2 = (MaterialButton) findViewById(R.id.sdr);

        //class days
        btn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),StdClassDaysActivity.class));
        });

        //Study Data

    }
}