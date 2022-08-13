package com.codelegacy.smartstudy;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
import androidx.annotation.NonNull;
import android.widget.ArrayAdapter;


public class par_dashboard extends AppCompatActivity {

    Spinner sp;
    Button show;
    DatabaseReference spinnerref;
    ArrayList<stddata> data;
    ArrayAdapter<String> dataadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_par_dashboard);
   fetch();
    }

    //holder for data from database




    public void fetch()
    {
        //connection String
        DatabaseReference firebaseDatabase  = FirebaseDatabase.getInstance("https://firstapp-4043d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Student");
         data = new ArrayList<>();
      List<String> item=new ArrayList<>();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                //load data from database in class
                for(DataSnapshot firedata : snapshot.getChildren())
                {
                    stddata s1 = firedata.getValue(stddata.class);
                    data.add(s1);
                    item.add(String.valueOf(s1.s_name));
                    ArrayAdapter<String> adpter=new ArrayAdapter<String>(par_dashboard.this, com.google.android.material.R.layout.support_simple_spinner_dropdown_item,item);

                    sp.setAdapter(adpter);
                }





//                FetchDatabase f1 = new FetchDatabase(selectdata.this,data);
//                lv.setAdapter(f1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {


            }
        });
}}