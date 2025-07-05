package com.example.domain.repo;


import com.example.domain.model.weatherModels.Result;

public interface WeatherRepository {
    Result getWeather(double latitude, double longitude) ;
}
