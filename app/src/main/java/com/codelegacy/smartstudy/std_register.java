package com.codelegacy.smartstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class std_register extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_register);

        mAuth = FirebaseAuth.getInstance();
        EditText sname, saddress,sage,semail,suser,spass;
        Button s_reg;

        sname = findViewById(R.id.s_name);
        saddress = findViewById(R.id.s_address);
        sage = findViewById(R.id.s_age);
        semail = findViewById(R.id.s_email);
        suser = findViewById(R.id.s_user);
        spass = findViewById(R.id.s_pass);
        s_reg = findViewById(R.id.S_regbtn);

        s_reg.setOnClickListener(view->{
            String s_email = semail.getText().toString().trim();
            String s_pass = spass.getText().toString().trim();

            if(s_email.isEmpty()){
                semail.setError("Make sure to fill this field");
                semail.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(s_email).matches()){
                semail.setError("Email Is Not Vaild");
                semail.requestFocus();
                return;
            }


            if(s_pass.isEmpty()){
                spass.setError("Field Is Empty");
                spass.requestFocus();
                return;
            }


            if(s_pass.length() < 6){
                spass.setError("Password is less then 6 words!");
                spass.requestFocus();
                return;
            }



            mAuth.createUserWithEmailAndPassword(suser.getText().toString(),spass.getText().toString()).addOnSuccessListener(std_register.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(std_register.this, "inserted", Toast.LENGTH_SHORT).show();
                }
            });


            mAuth.createUserWithEmailAndPassword(suser.getText().toString(),spass.getText().toString()).addOnFailureListener(std_register.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(std_register.this, "Reg Failed", Toast.LENGTH_LONG).show();
                }
            });
            DatabaseReference s_db = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("student");
            String s_id = System.currentTimeMillis()+"";
            s_db.child(s_id).setValue(s_db);

        });
    }
}