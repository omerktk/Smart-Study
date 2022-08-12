package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class TeaLoginActivity extends AppCompatActivity {
    MaterialButton btn,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_login);

        btn = (MaterialButton) findViewById(R.id.loginbtn76);
        btn2 = (MaterialButton) findViewById(R.id.btn276);

        btn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaDashActivity.class));
            Toast.makeText(TeaLoginActivity.this, "Login Done", Toast.LENGTH_LONG).show();
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaRegActivity.class));
        });
    }
}