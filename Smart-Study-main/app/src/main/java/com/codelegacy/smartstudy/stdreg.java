package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class stdreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stdreg);

        EditText s_name,s_age,s_username,s_pass;
        Button s_reg;

        s_name = findViewById(R.id.s_name);
        s_age = findViewById(R.id.s_age);
        s_username = findViewById(R.id.s_username);
        s_pass = findViewById(R.id.s_password);
        s_reg = findViewById(R.id.s_reg);

        s_reg.setOnClickListener(view->{
            DatabaseReference s_db= FirebaseDatabase.getInstance().getReference();
        String s_idgen = System.currentTimeMillis()+"";
        stddata s_data = new stddata(s_name.getText().toString(),s_age.getText().toString(),s_username.getText().toString(),s_pass.getText().toString());
        s_db.child(s_idgen).setValue(s_data);
        });

    }
}