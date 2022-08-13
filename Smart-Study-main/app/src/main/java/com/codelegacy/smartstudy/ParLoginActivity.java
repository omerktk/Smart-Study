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

public class ParLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText p_user,p_pass;
    private FirebaseAuth mAuth;
    MaterialButton p_login,p_reg_red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_login);

        p_user = findViewById(R.id.p_user);
        p_pass = findViewById(R.id.p_pass);
        p_login = (MaterialButton) findViewById(R.id.p_login);
        p_reg_red = (MaterialButton) findViewById(R.id.p_reg_red);

        //button 1 login
        p_login.setOnClickListener(view -> {

            userLogin();

        });


        //button 2 change screen onclick
        p_reg_red.setOnClickListener(view -> {
            Intent intent = new Intent(ParLoginActivity.this,par_register.class);
            startActivity(intent);
        });


    }

    private void userLogin() {

        String puser = p_user.getText().toString().trim();
        String ppass = p_pass.getText().toString().trim();

        if(puser.isEmpty()){
            p_user.setError("Make sure to fill this field");
            p_user.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(puser).matches()){
            p_user.setError("Email Is Not Vaild");
            p_user.requestFocus();
            return;
        }


        if(ppass.isEmpty()){
            p_pass.setError("Field Is Empty");
            p_pass.requestFocus();
            return;
        }


        if(ppass.length() < 6){
            p_pass.setError("Password is less then 6 words!");
            p_pass.requestFocus();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(puser,ppass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ParLoginActivity.this, "Login is Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ParLoginActivity.this,par_dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ParLoginActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}