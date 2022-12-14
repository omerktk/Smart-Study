package com.codelegacy.smartstudy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class TeaStudyDataAdapter extends BaseAdapter {


    //array with model



    ArrayList<JavaModal> data;
    Context context;

    String Sref = "gs://apptest-fed14.appspot.com/images";

    //alt insert to create contractor
    public TeaStudyDataAdapter(ArrayList<JavaModal> data, Context context) {
        this.data = data;
        this.context = context;

    }


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
        View root = LayoutInflater.from(context).inflate(R.layout.teastudydatalistview, null);

        TextView pname = root.findViewById(R.id.textView1);
        TextView pdetails = root.findViewById(R.id.textView2);



        pname.setText(data.get(position).pname);
        pdetails.setText(data.get(position).pdetail);






        return root;
    }
}
