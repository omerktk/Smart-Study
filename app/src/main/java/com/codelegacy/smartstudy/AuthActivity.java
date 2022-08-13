package com.codelegacy.smartstudy;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class AuthActivity extends AppCompatActivity {
    MaterialCardView logoutbtn,play,score,about;
    ImageView img_t,img_std,img_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        img_t = findViewById(R.id.img_t);
        img_std = findViewById(R.id.img_std);
        img_p = findViewById(R.id.img_p);
        Glide.with(AuthActivity.this).load(getDrawable(R.drawable.teacher)).into(img_t);
        Glide.with(AuthActivity.this).load(getDrawable(R.drawable.student)).into(img_std);
        Glide.with(AuthActivity.this).load(getDrawable(R.drawable.parents)).into(img_p);


        play = (MaterialCardView) findViewById(R.id.play);
        score = (MaterialCardView) findViewById(R.id.high);
        about = (MaterialCardView) findViewById(R.id.about);


        play.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaLoginActivity.class));
        });

        score.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),ParLoginActivity.class));
        });

        about.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),StdLoginActivity.class));
        });

//        quit.setOnClickListener(view -> {
//            new AlertDialog.Builder(this)
//                    .setTitle("Exit")
//                    .setMessage("Are you sure you want to exit?")
//                    .setCancelable(false)
//                    .setNegativeButton(android.R.string.no, null)
//                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//
//                        public void onClick(DialogInterface arg0, int arg1) {
//                            moveTaskToBack(true);
//                            android.os.Process.killProcess(android.os.Process.myPid());
//                            System.exit(1);
//                        }
//                    }).create().show();
//
//        });


    }



    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                }).create().show();

    }
}