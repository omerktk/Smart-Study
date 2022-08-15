package com.codelegacy.smartstudy;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeaStudentList extends AppCompatActivity {


    ListView lv;

    DatabaseReference ref;

    ArrayList<Student> data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teastudentlist);
        ref = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("student");
        lv = findViewById(R.id.listalldata);

        fetch();



    }

    public void fetch(){
        data = new ArrayList<>();

//write data ref / then addvalue / then new space enter

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot firedata : snapshot.getChildren())
                {
                    Student s12 = firedata.getValue(Student.class);
                    data.add(s12);
                }
                TeaStudentAdapter f1 = new TeaStudentAdapter(data, TeaStudentList.this);
                lv.setAdapter(f1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




    }
}