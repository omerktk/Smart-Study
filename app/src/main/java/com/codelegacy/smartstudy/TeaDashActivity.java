package com.codelegacy.smartstudy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


public class TeaDashActivity extends AppCompatActivity {
    ImageView gif;
    MaterialCardView regstd,upsdata,sdata,mystd,marks,addmarks;
    TextView mytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_dash);
        regstd = (MaterialCardView) findViewById(R.id.regstd);
        upsdata = (MaterialCardView) findViewById(R.id.upsdata);
        sdata = (MaterialCardView) findViewById(R.id.sdata);
        mystd = (MaterialCardView) findViewById(R.id.mystd);
        marks = (MaterialCardView) findViewById(R.id.mark60);
        addmarks = (MaterialCardView) findViewById(R.id.addmark60);
        mytext = findViewById(R.id.mytext);

        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
        String name = sp.getString("iname", "");
        mytext.setText("welcome "+name);

        gif = findViewById(R.id.gif);
        Glide.with(TeaDashActivity.this).load(getDrawable(R.drawable.cap)).into(gif);

        regstd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),StdRegActivity.class));
        });

        sdata.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataList.class));
        });

        mystd.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudentList.class));
        });

        upsdata.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaStudyDataUpload.class));
        });

        marks.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkList.class));
        });

        addmarks.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(),TeaMarkDataUpload.class));
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