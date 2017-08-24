package com.ferysyukur.recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ferysyukur.recyclerview.R;
import com.ferysyukur.recyclerview.model.Hewan;

import java.util.ArrayList;

/**
 * Created by ferysyukur on 5/21/17.
 */

public class HewanAdapter extends ArrayAdapter<Hewan> {

    Context context;
    int layoutResourceId;
    ArrayList<Hewan> data = null;

    public HewanAdapter(Context context, int resource, ArrayList<Hewan> data) {
        super(context, resource, data);
        this.context = context;
        this.layoutResourceId = resource;
        this.data = data;
    }

    static class HewanHolder{
        ImageView img;
        TextView title;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        HewanHolder holder = null;

        if (row == null){

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new HewanHolder();
            holder.img = (ImageView) row.findViewById(R.id.imgHewan);
            holder.title = (TextView) row.findViewById(R.id.txtnamaHewan);

            row.setTag(holder);
        } else{

            holder = (HewanHolder)row.getTag();
        }

        Hewan hewan = data.get(position);
        holder.img.setImageResource(R.mipmap.ic_launcher);
        holder.title.setText(hewan.nama);

        return  row;
    }



}
