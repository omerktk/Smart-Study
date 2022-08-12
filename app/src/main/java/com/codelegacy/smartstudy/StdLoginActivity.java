package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class StdLoginActivity extends AppCompatActivity {

    MaterialButton btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_login);
        btn = (MaterialButton) findViewById(R.id.loginbtn27);

        btn.setOnClickListener(view -> {
            Toast.makeText(StdLoginActivity.this, "Login Done", Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext(),StdDashActivity.class));
        });
    }
}