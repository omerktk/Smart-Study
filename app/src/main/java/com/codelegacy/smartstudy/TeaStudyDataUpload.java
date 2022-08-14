package com.codelegacy.smartstudy;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TeaStudyDataUpload extends AppCompatActivity {
    MaterialButton btn;
    ProgressDialog pd;
    DatabaseReference ref = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("StudyData");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teastudydataupload);

        btn = (MaterialButton) findViewById(R.id.btnUpload);


        //button Upload Image
        btn.setOnClickListener(view -> {
            uploadImage();
        });

    }



    private void uploadImage() {
        String maxid = System.currentTimeMillis()+"" ;

            pd = new ProgressDialog(this);
            pd.setTitle("Uploading File...");
            pd.show();
            EditText name = findViewById(R.id.username1);
            EditText  mail = findViewById(R.id.password1);

            //data
            JavaModal member = new JavaModal(name.getText().toString(),mail.getText().toString(), "null");
            ref.child(maxid).setValue(member);
        pd.hide();
        name.setText("");
        mail.setText("");

        Toast.makeText(TeaStudyDataUpload.this, "Uploaded", Toast.LENGTH_LONG).show();

    }

}