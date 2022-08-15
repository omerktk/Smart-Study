package com.codelegacy.smartstudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;


public class ParDashActivity extends AppCompatActivity {

    ImageView gif;
    EditText sbox;
    MaterialCardView xbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_dash);
        sbox = findViewById(R.id.xbox);
        xbtn = (MaterialCardView) findViewById(R.id.xbtn);


        xbtn.setOnClickListener(view -> {
            SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putString("uname", sbox.getText().toString());
            editor.commit();
            startActivity(new Intent(getApplicationContext(),TeaMarkList2.class));
        });

        gif = findViewById(R.id.gif);
        Glide.with(ParDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);
    }
}