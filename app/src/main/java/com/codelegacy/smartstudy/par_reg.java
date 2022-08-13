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
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class par_reg extends AppCompatActivity {
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_reg);

        mAuth = FirebaseAuth.getInstance();
        EditText pname, puser, ppass;
        MaterialCardView p_reg;

        pname = findViewById(R.id.p_name);
        puser = findViewById(R.id.p_user);
        ppass = findViewById(R.id.p_pass);
        p_reg = findViewById(R.id.p_regbtn);

        p_reg.setOnClickListener(view->{
            String p_user = puser.getText().toString().trim();
            String p_pass = ppass.getText().toString().trim();
            String p_name = pname.getText().toString().trim();

            if(p_name.isEmpty()){
                pname.setError("Make sure to fill this field");
                pname.requestFocus();
                return;
            }

            if(p_user.isEmpty()){
                puser.setError("Make sure to fill this field");
                puser.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(p_user).matches()){
                puser.setError("Email Is Not Vaild");
                puser.requestFocus();
                return;
            }


            if(p_pass.isEmpty()){
                ppass.setError("Field Is Empty");
                ppass.requestFocus();
                return;
            }


            if(p_pass.length() < 6){
                ppass.setError("Password is less then 6 words!");
                ppass.requestFocus();
                return;
            }



            mAuth.createUserWithEmailAndPassword(puser.getText().toString(),ppass.getText().toString()).addOnSuccessListener(par_reg.this, new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Toast.makeText(par_reg.this, "inserted", Toast.LENGTH_SHORT).show();
                }
            });


            mAuth.createUserWithEmailAndPassword(puser.getText().toString(),ppass.getText().toString()).addOnFailureListener(par_reg.this, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(par_reg.this, "Reg Failed", Toast.LENGTH_LONG).show();
                }
            });
            DatabaseReference t_db = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("parent");
            String t_id = System.currentTimeMillis()+"";
            teacher_data t_data = new teacher_data(pname.getText().toString(),puser.getText().toString(),ppass.getText().toString());
            t_db.child(t_id).setValue(t_data);
            Toast.makeText(par_reg.this, "Reg Done", Toast.LENGTH_LONG).show();
            super.onBackPressed();
        });
    }
}