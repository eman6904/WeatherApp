package com.example.domain.model;

import java.util.List;

public class Daily {
    public List<String> time;
    public List<Double> temperature_2m_max;
    public List<Double> temperature_2m_min;
    public List<String> sunrise;
    public List<String> sunset;
    public List<Double> uv_index_max;
    public List<Integer> weathercode;

    public Daily(List<String> time, List<Double> temperature2mMax, List<Double> temperature2mMin, List<String> sunrise, List<String> sunset, List<Double> uvIndexMax, List<Integer> weathercode) {
    }
}
