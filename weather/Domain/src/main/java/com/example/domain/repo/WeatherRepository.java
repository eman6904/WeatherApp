package com.example.domain.repo;


import com.example.domain.model.Result;
import com.example.domain.model.WeatherResponse;

import java.io.IOException;

public interface WeatherRepository {
    Result getWeather(double latitude, double longitude) ;
}
