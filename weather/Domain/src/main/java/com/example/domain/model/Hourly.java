package com.example.domain.model;

import java.util.List;

public class Hourly {
    public List<String> time;
    public List<Double> temperature_2m;
    public List<Integer> weathercode;
    public List<Double> uv_index;
    public List<Double> precipitation;

    public Hourly(List<String> time, List<Double> temperature2m, List<Integer> weathercode, List<Double> uvIndex, List<Double> precipitation) {
    }
}
