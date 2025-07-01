package com.example.data.remote;

import com.example.data.model.WeatherResponse;

import retrofit2.Call;

public class WeatherDataSourceImpl implements WeatherDataSource {

    private final WeatherDataSource api;

    public WeatherDataSourceImpl(String baseUrl) {
        this.api = ApiClient.createService(baseUrl, WeatherDataSource.class);
    }

    @Override
    public Call<WeatherResponse> getForecast(double latitude, double longitude, String current, String hourly, String daily, String timezone, boolean airQuality) {
        return api.getForecast(latitude, longitude, current, hourly, daily, timezone, airQuality);
    }
}

