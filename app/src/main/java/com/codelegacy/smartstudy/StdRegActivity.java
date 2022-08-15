package com.codelegacy.smartstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StdRegActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    EditText tname, temail, tpass,trolenum,tage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_reg);
        mAuth = FirebaseAuth.getInstance();

        MaterialCardView btn_reg;
        
        trolenum = findViewById(R.id.role29);
        tname = findViewById(R.id.name25);
        tage = findViewById(R.id.age25);
        temail = findViewById(R.id.email25);
        tpass = findViewById(R.id.password25);
        btn_reg = findViewById(R.id.btn_id);

        btn_reg.setOnClickListener(view -> {
            regstd();
        });

    }

    public void regstd() {

        String strolenum = trolenum.getText().toString().trim();
        String stname = tname.getText().toString().trim();
        String stage = tage.getText().toString().trim();
        String stemail = temail.getText().toString().trim();
        String stpass = tpass.getText().toString().trim();


        if(strolenum.isEmpty()){
            trolenum.setError("Make sure to fill this field");
            trolenum.requestFocus();
            return;
        }

        if(stname.isEmpty()){
            tname.setError("Make sure to fill this field");
            tname.requestFocus();
            return;
        }

        if(stage.isEmpty()){
            tage.setError("Make sure to fill this field");
            tage.requestFocus();
            return;
        }

        if(stemail.isEmpty()){
            temail.setError("Make sure to fill this field");
            temail.requestFocus();
            return;
        }

        if(stpass.isEmpty()){
            tpass.setError("Make sure to fill this field");
            tpass.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(temail.getText().toString(),tpass.getText().toString()).addOnSuccessListener(StdRegActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

            }
        });


        mAuth.createUserWithEmailAndPassword(temail.getText().toString(),tpass.getText().toString()).addOnFailureListener(StdRegActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        DatabaseReference t_db = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("student");
        String t_id = System.currentTimeMillis()+"";
        Student t_data = new Student(t_id,trolenum.getText().toString(),tname.getText().toString(),tage.getText().toString(),temail.getText().toString(),tpass.getText().toString());
        t_db.child(t_id).setValue(t_data);
        trolenum.setText("");
        tname.setText("");
        tage.setText("");
        temail.setText("");
        tpass.setText("");
        Toast.makeText(StdRegActivity.this, "Reg Done", Toast.LENGTH_LONG).show();

    }
}