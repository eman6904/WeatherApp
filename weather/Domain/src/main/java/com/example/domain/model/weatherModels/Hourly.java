package com.example.domain.model.weatherModels;

import java.util.List;

public class Hourly {
    public List<String> time;
    public List<Double> temperature_2m;
    public List<Integer> weathercode;
    public List<Double> uv_index;
    public List<Double> precipitation;

    public Hourly(List<String> time, List<Double> temperature2m, List<Integer> weathercode, List<Double> uvIndex, List<Double> precipitation) {
        this.time = time;
        this.temperature_2m = temperature2m;
        this.weathercode = weathercode;
        this.uv_index = uvIndex;
        this.precipitation = precipitation;
    }
}
