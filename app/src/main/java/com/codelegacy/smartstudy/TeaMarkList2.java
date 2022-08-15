package com.codelegacy.smartstudy;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TeaMarkList2 extends AppCompatActivity {


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
                    SharedPreferences sp=getSharedPreferences("credentials",MODE_PRIVATE);
                    String name = sp.getString("uname", "");
                    //Toast.makeText(TeaMarkList2.this, "Login Failed"+name+" "+s1.pdetail, Toast.LENGTH_LONG).show();
                    if(s1.pimage.equals(name))
                    {
                        data.add(s1);
                    }

                }
                TeaMarkAdapter2 f1 = new TeaMarkAdapter2(data, TeaMarkList2.this);
                lv.setAdapter(f1);
            }




            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


    }
}