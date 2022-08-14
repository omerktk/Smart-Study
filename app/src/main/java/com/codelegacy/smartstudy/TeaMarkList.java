package com.codelegacy.smartstudy;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeaMarkList extends AppCompatActivity {


    ListView lv;

    DatabaseReference ref = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("Marks");

    ArrayList<JavaModal> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamarklist);
        lv = (ListView) findViewById(R.id.listalldata);
        fetch();
    }

    public void fetch(){
        data = new ArrayList<>();

//write data ref / then addvalue / then new space enter

        ValueEventListener valueEventListener = ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot firedata : dataSnapshot.getChildren()) {
                    JavaModal s1 = firedata.getValue(JavaModal.class);
                    data.add(s1);
                }
                TeaMarkAdapter f1 = new TeaMarkAdapter(data, TeaMarkList.this);
                lv.setAdapter(f1);
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


    }
}