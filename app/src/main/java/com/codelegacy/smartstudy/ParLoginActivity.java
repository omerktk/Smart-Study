package com.codelegacy.smartstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;
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

public class ParLoginActivity extends AppCompatActivity {

    DatabaseReference ref;
    EditText p_username,p_password;
    FirebaseAuth mAuth;
    MaterialCardView p_login;
    String pusername,ppassword;
    TextView p_reg_red;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_login);
        mAuth = FirebaseAuth.getInstance();

        p_username = findViewById(R.id.p_username);
        p_password = findViewById(R.id.p_password);
        p_login = (MaterialCardView) findViewById(R.id.p_login);
        p_reg_red = (TextView) findViewById(R.id.p_reg_red);

        //button 1 login
        p_login.setOnClickListener(view -> {
            userLogin();
        });


        //button 2 change screen onclick
        p_reg_red.setOnClickListener(view -> {
            Intent reg = new Intent(ParLoginActivity.this,par_reg.class);
            startActivity(reg);
        });

    }

    private void userLogin() {

        pusername = p_username.getText().toString().trim();
        ppassword = p_password.getText().toString().trim();

        if(pusername.isEmpty()){
            p_username.setError("Make sure to fill this field");
            p_username.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(pusername).matches()){
            p_username.setError("Email Is Not Vaild");
            p_username.requestFocus();
            return;
        }


        if(ppassword.isEmpty()){
            p_password.setError("Field Is Empty");
            p_password.requestFocus();
            return;
        }


        if(ppassword.length() < 6){
            p_password.setError("Password is less then 6 words!");
            p_password.requestFocus();
            return;
        }
        pd = new ProgressDialog(this);
        pd.setTitle("Please Wait...");
        pd.show();


        mAuth.signInWithEmailAndPassword(pusername,ppassword).addOnSuccessListener(ParLoginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                //  String uid = authResult.getUser().getUid();
                fetch();

            }
        });

        mAuth.signInWithEmailAndPassword(pusername,ppassword).addOnFailureListener(ParLoginActivity.this, new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ParLoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }



    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("parent");

        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    teacher_data s1 = firedata.getValue(teacher_data.class);
                    if(s1.t_user.equals(pusername))
                    {
                        pd.hide();
                        startActivity(new Intent(getApplicationContext(),ParDashActivity.class));
                        finish();
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