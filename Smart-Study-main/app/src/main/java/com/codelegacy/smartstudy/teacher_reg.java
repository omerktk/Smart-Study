package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class teacher_reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        EditText tname, tuser, tpass;
        Button t_reg;

        tname = findViewById(R.id.t_name);
        tuser = findViewById(R.id.t_user);
        tpass = findViewById(R.id.t_pass);
        t_reg = findViewById(R.id.t_regbtn);

        t_reg.setOnClickListener(view->{
            DatabaseReference t_db = FirebaseDatabase.getInstance().getReference();
            String t_id = System.currentTimeMillis()+"";
            teacher_data t_data = new teacher_data(tname.getText().toString(),tuser.getText().toString(),tpass.getText().toString());
            t_db.child(t_id).setValue(t_data);
        });
    }
}