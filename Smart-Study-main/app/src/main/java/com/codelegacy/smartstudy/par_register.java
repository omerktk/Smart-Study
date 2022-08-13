package com.codelegacy.smartstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class par_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_register);


        EditText name,puser,ppass;
        Button regbtn;

        name = findViewById(R.id.f_name);
        puser = findViewById(R.id.user);
        ppass = findViewById(R.id.pass);
        regbtn = findViewById(R.id.regbtn);

        regbtn.setOnClickListener(view->{
            DatabaseReference db = FirebaseDatabase.getInstance().getReference();
            String pid = System.currentTimeMillis()+"";
            paretndata data = new paretndata(name.getText().toString(),puser.getText().toString(),ppass.getText().toString());
            db.child(pid).setValue(data);
        });


    }
}