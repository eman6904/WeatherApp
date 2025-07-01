package com.example.domain.repo;


import com.example.domain.model.WeatherResponse;

import java.io.IOException;

public interface WeatherRepository {
    WeatherResponse getWeather(double latitude, double longitude) throws IOException;
}
