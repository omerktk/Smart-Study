package com.codelegacy.smartstudy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

public class StdDashActivity extends AppCompatActivity {
    MaterialCardView btn,btn2;
    ImageView gif;
    TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_dash);

        gif = findViewById(R.id.gif);
        Glide.with(StdDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);

        btn = (MaterialCardView) findViewById(R.id.cls);
        btn2 = (MaterialCardView) findViewById(R.id.sdr);
        mytext = findViewById(R.id.mytext);

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        String name = sp.getString("iname", "");
        mytext.setText("welcome "+name);

        //class days
        btn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataList.class));
        });
        btn2.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkList2.class));
        });
        //Study Data

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