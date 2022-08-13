package com.codelegacy.smartstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
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

public class TeaRegActivity extends AppCompatActivity {
        FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_reg);
        mAuth = FirebaseAuth.getInstance();
        EditText tname, tuser, tpass;
        MaterialCardView t_reg;
        TextView btn_reg;

        tname = findViewById(R.id.t_name);
        tuser = findViewById(R.id.t_user);
        tpass = findViewById(R.id.t_pass);
        t_reg = findViewById(R.id.t_regbtn);
        btn_reg = findViewById(R.id.btn_reg);

        btn_reg.setOnClickListener(view -> {
            Intent reg = new Intent(TeaRegActivity.this,TeaLoginActivity.class);
            startActivity(reg);
        });

        t_reg.setOnClickListener(view->{
            String suser = tuser.getText().toString().trim();
            String spass = tpass.getText().toString().trim();
            String sname = tname.getText().toString().trim();

            if(sname.isEmpty()){
                tname.setError("Make sure to fill this field");
                tname.requestFocus();
                return;
            }

            if(suser.isEmpty()){
                tuser.setError("Make sure to fill this field");
                tuser.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(suser).matches()){
                tuser.setError("Email Is Not Vaild");
                tuser.requestFocus();
                return;
            }


            if(spass.isEmpty()){
                tpass.setError("Field Is Empty");
                tpass.requestFocus();
                return;
            }


            if(spass.length() < 6){
                tpass.setError("Password is less then 6 words!");
                tpass.requestFocus();
                return;
            }



            mAuth.createUserWithEmailAndPassword(tuser.getText().toString(),tpass.getText().toString()).addOnSuccessListener(TeaRegActivity.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(TeaRegActivity.this, "inserted", Toast.LENGTH_SHORT).show();
                }
            });


            mAuth.createUserWithEmailAndPassword(tuser.getText().toString(),tpass.getText().toString()).addOnFailureListener(TeaRegActivity.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(TeaRegActivity.this, "Reg Failed", Toast.LENGTH_LONG).show();
                }
            });
            DatabaseReference t_db = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("teacher");
            String t_id = System.currentTimeMillis()+"";
            teacher_data t_data = new teacher_data(tname.getText().toString(),tuser.getText().toString(),tpass.getText().toString());
            t_db.child(t_id).setValue(t_data);
            Toast.makeText(TeaRegActivity.this, "Reg Done", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        });
    }
}