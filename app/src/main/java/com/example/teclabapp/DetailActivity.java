package com.example.teclabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        String ciudadElegida = myIntent.getStringExtra("nombreCiudad");

        TextView nombreCiudad = findViewById(R.id.tvCiudad);

        nombreCiudad.setText(ciudadElegida);
    }
}