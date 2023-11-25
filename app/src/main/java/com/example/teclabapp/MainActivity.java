package com.example.teclabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listarCiudades(View view){
        Intent myIntent = new Intent(this, ListActivity.class);
        startActivity(myIntent);
    }

    public void irDetalle(View view){
        Intent myIntent = new Intent(this, DetailActivity.class);
        //myIntent.putExtra("nombreCiudad", "Buenos Aires");
        myIntent.putExtra("lat", "-38.7196");
        myIntent.putExtra("lon", "-62.2724");
        startActivity(myIntent);
    }

}