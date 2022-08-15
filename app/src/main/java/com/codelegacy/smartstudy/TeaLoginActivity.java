package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;

import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeaLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText t_user,t_pass;
    FirebaseAuth mAuth;
    MaterialCardView t_login;
    TextView t_reg_red;
    String suser,spass;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_login);

        mAuth = FirebaseAuth.getInstance();

        t_user = findViewById(R.id.t_user);
        t_pass = findViewById(R.id.t_pass);
        t_login = (MaterialCardView) findViewById(R.id.t_login);
        t_reg_red = findViewById(R.id.t_reg_red);

        //button 1 login
        t_login.setOnClickListener(view -> {
            userLogin();
        });


        //button 2 change screen onclick
        t_reg_red.setOnClickListener(view -> {
            Intent reg = new Intent(TeaLoginActivity.this,TeaRegActivity.class);
            startActivity(reg);
        });

    }

    private void userLogin() {

         suser = t_user.getText().toString().trim();
        spass = t_pass.getText().toString().trim();

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
        pd = new ProgressDialog(this);
        pd.setTitle("Please Wait...");
        pd.show();


        mAuth.signInWithEmailAndPassword(suser,spass).addOnSuccessListener(TeaLoginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

              //  String uid = authResult.getUser().getUid();
                fetch();


            }
        });

        mAuth.signInWithEmailAndPassword(suser,spass).addOnFailureListener(TeaLoginActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(TeaLoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                pd.hide();
                t_user.setText("");
                t_pass.setText("");
            }
        });
    }



    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("teacher");



        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    teacher_data s1 = firedata.getValue(teacher_data.class);
                    if(s1.t_user.equals(suser))
                    {
                        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("iname", s1.t_name.toString());
                        editor.commit();

                        startActivity(new Intent(getApplicationContext(),TeaDashActivity.class));
                        finish();
                        pd.hide();
                        t_user.setText("");
                        t_pass.setText("");
                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });
    }

}