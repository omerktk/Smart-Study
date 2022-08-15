package com.codelegacy.smartstudy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TeaStudentAdapter extends BaseAdapter {


    //array with model

    ArrayList<Student> data;
    Context context;
    DatabaseReference db;
    public TeaStudentAdapter(ArrayList<Student> data, Context context) {
        this.data = data;
        this.context = context;
    }

    String Sref = "gs://apptest-fed14.appspot.com/images";

    //alt insert to create contractor



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //write in this
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = LayoutInflater.from(context).inflate(R.layout.teastudentlistview, null);

        TextView pname = root.findViewById(R.id.textView1);
        TextView pdetails = root.findViewById(R.id.textView2);
        TextView text3 = root.findViewById(R.id.textView3);
        ImageView delete = root.findViewById(R.id.deleteimg);


        pname.setText(data.get(position).getStdname()+"");
        pdetails.setText(data.get(position).getEnrollno()+"");
        text3.setText(data.get(position).getSemail()+"");

        delete.setOnClickListener(view1 -> {
            db = FirebaseDatabase.getInstance("https://smart-study-cdbd4-default-rtdb.firebaseio.com/").getReference("student");
            db.child(data.get(position).getStdid()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(context ,"Delete the data",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context , TeaDashActivity.class);
                    context.startActivity(intent);
                }
            });
        });
        return root;
    }
}
