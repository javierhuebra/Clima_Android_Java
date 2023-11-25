package com.example.teclabapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface Api {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String TOKEN = "ff9a0c998f50abbc31fe4b4aa7492dcf";
    String UNITS = "metric";

    String LANG = "es";

    @GET("weather")
    Call<Result> getWeather(@Query("lat") Float latitud,
                            @Query("lon") Float longitud,
                            @Query("appid") String token,
                            @Query("units") String units,
                            @Query("lang") String lang);
}
