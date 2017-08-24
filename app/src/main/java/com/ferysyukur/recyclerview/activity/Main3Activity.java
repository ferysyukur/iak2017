package com.ferysyukur.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ferysyukur.recyclerview.R;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements RecyclerAdapter.ItemClickListener{

    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final EditText edtNama = (EditText) findViewById(R.id.editNamaHewan);
        Button btnSumbit = (Button) findViewById(R.id.btnSubmit);

        final ArrayList<String> animalList = new ArrayList<>();
        animalList.add("Horse");
        animalList.add("Cow");
        animalList.add("Camel");
        animalList.add("Sheep");
        animalList.add("Goat");

        btnSumbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String addAnimal = edtNama.getText().toString();
                animalList.add(addAnimal);
                adapter.notifyDataSetChanged();
                edtNama.setText("");
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, animalList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
