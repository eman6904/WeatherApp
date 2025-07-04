package com.example.data.repoImpl;

import android.util.Log;

import com.example.data.mapper.WeatherMapper;
import com.example.domain.model.Result;
import com.example.data.remote.dataSource.WeatherDataSource;
import com.example.domain.repo.WeatherRepository;


import java.io.IOException;

import retrofit2.Response;

public class WeatherRepositoryImpl implements WeatherRepository {

    private final WeatherDataSource dataSource;

    public WeatherRepositoryImpl(WeatherDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Result getWeather(double latitude, double longitude) {
        try {

            Response<com.example.data.model.WeatherResponse> response = dataSource.getForecast(
                    latitude,
                    longitude,
                    "temperature_2m,weathercode",
                    "temperature_2m,weathercode,uv_index,precipitation",
                    "temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,weathercode",
                    "Africa/Cairo",
                    true
            ).execute();

            if (response.isSuccessful() && response.body() != null) {
                return Result.success(WeatherMapper.toDomainModel(response.body()));
            } else {
                Log.e("WeatherRepository", "API Error: " + response.code());
                return Result.error("api error");
            }

        } catch (IOException e) {
           // e.printStackTrace();
            Log.e("WeatherRepository", "API exception: " + e.getMessage());
            return Result.error("network error");
        }
    }
}

