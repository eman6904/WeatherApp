package com.example.data.repoImpl;

import com.example.data.mapper.WeatherMapper;
import com.example.domain.model.WeatherResponse;
import com.example.data.remote.WeatherDataSource;
import com.example.domain.repo.WeatherRepository;


import java.io.IOException;

import retrofit2.Response;

public class WeatherRepositoryImpl implements WeatherRepository {

    private final WeatherDataSource dataSource;

    public WeatherRepositoryImpl(WeatherDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public WeatherResponse getWeather(double latitude, double longitude) throws IOException {
        Response<com.example.data.model.WeatherResponse> response = dataSource.getForecast(
                latitude,
                longitude,
                "temperature_2m,weathercode",
                "temperature_2m,weathercode,uv_index,precipitation",
                "temperature_2m_max,temperature_2m_min,sunrise,sunset,uv_index_max,weathercode",
                "auto",
                false
        ).execute();

        if (response.isSuccessful() && response.body() != null) {
            return WeatherMapper.toDomainModel(response.body());
        } else {
            throw new IOException("API Error: " + response.code());
        }
    }
}
