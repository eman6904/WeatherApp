package com.example.data.repoImpl;


import com.example.data.mapper.weatherMapper.WeatherMapper;
import com.example.data.model.weatherModels.WeatherResponse;
import com.example.domain.model.weatherModels.Result;
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

            Response<WeatherResponse> response = dataSource.getForecast(
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

                return Result.error("Something went wrong");            }

        } catch (IOException e) {

            return Result.error("Check your internet connection");
        }
    }
}

