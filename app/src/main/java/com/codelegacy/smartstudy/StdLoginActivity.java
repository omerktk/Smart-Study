package com.codelegacy.smartstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StdLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText s_user,s_pass;
    FirebaseAuth mAuth;
    MaterialCardView slogin;
    String susername,spassword;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_std_login);

        pd = new ProgressDialog(this);
        pd.setTitle("Please Wait...");
        mAuth = FirebaseAuth.getInstance();

        s_user = findViewById(R.id.s_username);
        s_pass = findViewById(R.id.s_password);
        slogin = (MaterialCardView) findViewById(R.id.s_login);

        //button 1 login
        slogin.setOnClickListener(view -> {
            userLogin();

            pd.show();
        });
    }

    private void userLogin() {

        susername = s_user.getText().toString().trim();
        spassword = s_pass.getText().toString().trim();

        if(susername.isEmpty()){
            s_user.setError("Make sure to fill this field");
            s_user.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(susername).matches()){
            s_user.setError("Email Is Not Vaild");
            s_user.requestFocus();
            return;
        }


        if(spassword.isEmpty()){
            s_pass.setError("Field Is Empty");
            s_pass.requestFocus();
            return;
        }


        if(spassword.length() < 6){
            s_pass.setError("Password is less then 6 words!");
            s_pass.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(susername,spassword).addOnSuccessListener(StdLoginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                //  String uid = authResult.getUser().getUid();
                fetch();

            }
        });

        mAuth.signInWithEmailAndPassword(susername,spassword).addOnFailureListener(StdLoginActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(StdLoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                pd.hide();
                s_user.setText("");
                s_pass.setText("");
            }
        });
    }



    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("student");

        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    Student s1 = firedata.getValue(Student.class);
                    if(s1.semail.equals(susername))
                    {

                        startActivity(new Intent(getApplicationContext(),StdDashActivity.class));
                        finish();
                        pd.hide();
                        s_user.setText("");
                        s_pass.setText("");
                        SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putString("uname", s1.enrollno.toString());
                        editor.putString("iname", s1.stdname.toString());
                        editor.commit();
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