package com.example.domain.model.weatherModels;

public class Current {
    public String time;
    public int interval;
    public double temperature_2m;
    public int weathercode;

    public Current(String time, int interval, double temperature2m, int weathercode) {
        this.time = time;
        this.interval = interval;
        this.temperature_2m = temperature2m;
        this.weathercode = weathercode;
    }
}
