package com.example.teclabapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;

public class DetailActivity extends AppCompatActivity {

    TextView nameOfCity, tempActual, tempMax, tempMin, description;
    float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        latitud = myIntent.getFloatExtra("lat", 0.0F);
        longitud = myIntent.getFloatExtra("lon", 0.0F);

        nameOfCity = findViewById(R.id.tvCiudad);
        tempActual = findViewById(R.id.tvTempActual);
        tempMax = findViewById(R.id.tvTempMax);
        description = findViewById(R.id.tvDescription);
        tempMin = findViewById(R.id.tvTempMin);

        getActualWeather();



        //String ciudadElegida = myIntent.getStringExtra("nombreCiudad");
        //TextView nombreCiudad = findViewById(R.id.tvCiudad);
        //nombreCiudad.setText(ciudadElegida);
    }

    private void getActualWeather(){
        Call<Result> call = RetroFitClient.getInstance().getMyApi().getWeather(latitud, longitud, Api.TOKEN, Api.UNITS, Api.LANG);
        call.enqueue(new retrofit2.Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                if(response.isSuccessful()){
                    Result result = response.body();
                    nameOfCity.setText(result.name);
                    tempActual.setText(String.valueOf(result.main.temp.shortValue()));
                    tempMax.setText(String.valueOf(result.main.temp_max.shortValue()));
                    tempMin.setText(String.valueOf(result.main.temp_min.shortValue()));
                    description.setText(result.weather.get(0).description);


                } else {
                    Toast.makeText(DetailActivity.this, "Error en la respuesta", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}