package com.ferysyukur.recyclerview.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ferysyukur.recyclerview.model.Hewan;
import com.ferysyukur.recyclerview.adapter.HewanAdapter;
import com.ferysyukur.recyclerview.R;

import java.util.ArrayList;

public class ListHewanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_hewan);

        ListView list = (ListView) findViewById(R.id.listHewan);

        final ArrayList<Hewan> data = new ArrayList<>();

        final Hewan ayam = new Hewan(R.mipmap.ic_launcher, "Ayam");
        final Hewan sapi = new Hewan(R.mipmap.ic_launcher_round, "Sapi");

        data.add(ayam);
        data.add(sapi);

        data.add(new Hewan(R.mipmap.ic_launcher,"Add New"));

        HewanAdapter adapter = new HewanAdapter(this,
                R.layout.list_item_hewan,
                data);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Hewan hewan = data.get(position);
                Toast.makeText(ListHewanActivity.this, hewan.icon, Toast.LENGTH_SHORT).show();
                Intent toTarget = new Intent(getApplicationContext(), DetailHewanActivity.class);
                toTarget.putExtra("nama",hewan.nama);
                toTarget.putExtra("icon",hewan.icon);
                startActivity(toTarget);
            }
        });
    }
}
