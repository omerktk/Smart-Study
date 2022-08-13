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

public class TeaLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText t_user,t_pass;
    private FirebaseAuth mAuth;
    MaterialButton t_login,t_reg_red;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_login);

        t_user = findViewById(R.id.t_user);
        t_pass = findViewById(R.id.t_pass);
        t_login = (MaterialButton) findViewById(R.id.t_login);
        t_reg_red = (MaterialButton) findViewById(R.id.t_reg_red);

        //button 1 login
        t_login.setOnClickListener(view -> {

            userLogin();

        });


        //button 2 change screen onclick
        t_reg_red.setOnClickListener(view -> {
            Intent intent = new Intent(TeaLoginActivity.this,teacher_reg.class);
            startActivity(intent);
        });


    }

    private void userLogin() {

        String suser = t_user.getText().toString().trim();
        String spass = t_pass.getText().toString().trim();

        if(suser.isEmpty()){
            t_user.setError("Make sure to fill this field");
            t_user.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(suser).matches()){
            t_user.setError("Email Is Not Vaild");
            t_user.requestFocus();
            return;
        }


        if(spass.isEmpty()){
            t_pass.setError("Field Is Empty");
            t_pass.requestFocus();
            return;
        }


        if(spass.length() < 6){
            t_pass.setError("Password is less then 6 words!");
            t_pass.requestFocus();
            return;
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(suser,spass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(TeaLoginActivity.this, "Login is Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(TeaLoginActivity.this,tea_dashboard.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(TeaLoginActivity.this, "Failed to Login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}