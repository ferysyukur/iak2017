package com.ferysyukur.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    ArrayList<String> addArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNama = (EditText) findViewById(R.id.editText);
        Button btnAdd = (Button) findViewById(R.id.button);
        ListView list = (ListView) findViewById(R.id.listView);
        addArray.add("kucing");
        addArray.add("anjing");

        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                addArray);


        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String val = addArray.get(position);
                Toast.makeText(getApplicationContext(),val,Toast.LENGTH_SHORT).show();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editNama.getText().toString();
                addArray.add(str);
                adapter.notifyDataSetChanged();
                editNama.setText("");
            }
        });
    }
}
