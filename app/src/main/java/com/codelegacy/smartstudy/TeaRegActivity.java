package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class TeaRegActivity extends AppCompatActivity {

    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_reg);
        btn = (MaterialButton) findViewById(R.id.regbtn);

        btn.setOnClickListener(view -> {
            Toast.makeText(TeaRegActivity.this, "Reg Done", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        });
    }
}