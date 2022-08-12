package com.codelegacy.smartstudy;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class AuthActivity extends AppCompatActivity {
    MaterialButton logoutbtn,play,score,about,quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);


        play = (MaterialButton) findViewById(R.id.play);
        score = (MaterialButton) findViewById(R.id.high);
        about = (MaterialButton) findViewById(R.id.about);
        quit = (MaterialButton) findViewById(R.id.quit);

        play.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaLoginActivity.class));
        });

        score.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),ParLoginActivity.class));
        });

        about.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),StdLoginActivity.class));
        });

        quit.setOnClickListener(view -> {
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

        });


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