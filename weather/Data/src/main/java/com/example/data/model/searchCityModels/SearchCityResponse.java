package com.example.data.model.searchCityModels;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class SearchCityResponse {
    public List<CityResult> results;
    public double generationtime_ms;
}
