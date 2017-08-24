package com.ferysyukur.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ferysyukur.recyclerview.R;

import java.util.ArrayList;

import static android.R.id.list;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> addArray = new ArrayList<>();

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);

        ListView list = (ListView) findViewById(R.id.listView);

        addArray.add("kucing");
        addArray.add("anjing");
        addArray.add("musang");
        addArray.add("tupai");
        addArray.add("anak tupai");


        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addArray);
//
//
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ambil nilai dari array di posisi 'position'
                String val = addArray.get(position);

                Toast.makeText(getApplicationContext(),val,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
