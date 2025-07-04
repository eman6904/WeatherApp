package com.example.data.remote.dataSourceImp;

import com.example.data.model.WeatherResponse;
import com.example.data.remote.ApiClient;
import com.example.data.remote.HttpRoutes;
import com.example.data.remote.dataSource.WeatherDataSource;

import retrofit2.Call;

public class WeatherDataSourceImpl implements WeatherDataSource {

    private final WeatherDataSource api;

    public WeatherDataSourceImpl() {
        this.api = ApiClient.createService(HttpRoutes.ForecastWeather.GET_FORECAST, WeatherDataSource.class);
    }

    @Override
    public Call<WeatherResponse> getForecast(double latitude, double longitude, String current, String hourly, String daily, String timezone, boolean airQuality) {
        return api.getForecast(latitude, longitude, current, hourly, daily, timezone, airQuality);
    }
}

