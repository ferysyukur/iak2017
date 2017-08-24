package com.ferysyukur.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ferysyukur.recyclerview.R;

public class DetailHewanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hewan);

        ImageView img = (ImageView) findViewById(R.id.imgdeailhewan);
        TextView txt = (TextView) findViewById(R.id.txtTitleHewan);

        String nama = getIntent().getExtras().getString("nama");
        int icon = getIntent().getExtras().getInt("icon");

        img.setImageResource(icon);
        txt.setText(nama);
    }
}
