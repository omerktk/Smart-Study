package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.button.MaterialButton;


public class TeaDashActivity extends AppCompatActivity {

    MaterialButton regstd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_dash);
        regstd = (MaterialButton) findViewById(R.id.regstd);

        regstd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),std_register.class));
        });

    }
}