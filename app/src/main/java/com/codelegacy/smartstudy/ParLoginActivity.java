package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class ParLoginActivity extends AppCompatActivity {
    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_login);
        btn = (MaterialButton) findViewById(R.id.loginbtn);

        btn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),ParDashActivity.class));
            Toast.makeText(ParLoginActivity.this, "Login Done", Toast.LENGTH_LONG).show();
        });
    }
}