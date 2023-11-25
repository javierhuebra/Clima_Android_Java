package com.example.teclabapp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {
    @SerializedName("name")
    public String name;

    @SerializedName("weather")
    public ArrayList<Weather> weather;

    @SerializedName("main")
    public Main main;

    @SerializedName("visibility")
    public Integer visibility;


    public class Weather {
        @SerializedName("description")
        public String description;

    }

    public class Main {
        @SerializedName("temp")
        public Float temp;

        @SerializedName("temp_min")
        public Float temp_min;

        @SerializedName("temp_max")
        public Float temp_max;
    }

    // Constructor
    public Result(String name, ArrayList<Weather> weather, Main main, Integer visibility) {
        this.name = name;
        this.weather = weather;
        this.main = main;
        this.visibility = visibility;
    }



}