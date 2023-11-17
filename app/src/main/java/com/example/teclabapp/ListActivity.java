package com.example.teclabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<String> ciudades = new ArrayList<>(); //Infiere el tipo por eso al final no le pongo el String
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setUpListActivit();
    }

    private void setUpListActivit() {
        listView = (ListView) findViewById(R.id.list_item);

        ciudades.add("Buenos Aires");
        ciudades.add("La plata");
        ciudades.add("Córdoba");
        ciudades.add("Río Negro");
        ciudades.add("La Pampa");

        //ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, ciudades);

        //listView.setAdapter(arrayAdapter);

        CustomAdapter adapter = new CustomAdapter(this, ciudades);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                irDetalle((String) ciudades.get(position));
            }
        });


    }

    private void irDetalle(String ciudad){
        Intent myIntent = new Intent(this, DetailActivity.class);
        myIntent.putExtra("nombreCiudad", ciudad);
        startActivity(myIntent);
    }
}