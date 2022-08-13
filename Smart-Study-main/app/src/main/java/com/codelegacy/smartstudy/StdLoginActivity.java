package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StdLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText s_user,s_pass;
    private FirebaseAuth mAuth;
    MaterialButton s_login,s_reg_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_login);

            s_user = findViewById(R.id.s_user);
            s_pass = findViewById(R.id.s_pass);
            s_login = (MaterialButton) findViewById(R.id.s_login);
            s_reg_red = (MaterialButton) findViewById(R.id.s_reg_red);

            //button 1 login
            s_login.setOnClickListener(view -> {

                userLogin();

            });


            //button 2 change screen onclick
            s_reg_red.setOnClickListener(view -> {
                Intent intent = new Intent(StdLoginActivity.this,stdreg.class);
                startActivity(intent);
            });


        }

        private void userLogin() {

            String suser = s_user.getText().toString().trim();
            String spass = s_pass.getText().toString().trim();

            if(suser.isEmpty()){
                s_user.setError("Make sure to fill this field");
                s_user.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(suser).matches()){
                s_user.setError("Email Is Not Vaild");
                s_user.requestFocus();
                return;
            }


            if(spass.isEmpty()){
                s_pass.setError("Field Is Empty");
                s_pass.requestFocus();
                return;
            }


            if(spass.length() < 6){
                s_pass.setError("Password is less then 6 words!");
                s_pass.requestFocus();
                return;
            }

            FirebaseAuth.getInstance().signInWithEmailAndPassword(suser,spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(StdLoginActivity.this, "Login is Successful", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(StdLoginActivity.this,std_dashboard.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(StdLoginActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
}