package com.example.teclabapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClient {

    private static RetroFitClient instance = null;
    private Api myApi;

    private RetroFitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetroFitClient getInstance(){
        if(instance == null){
            instance = new RetroFitClient();
        }
        return instance;
    }

    public Api getMyApi(){
        return myApi;
    }
}
