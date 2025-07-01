package com.example.domain.useCase;

import com.example.domain.model.Result;
import com.example.domain.model.WeatherResponse;
import com.example.domain.repo.WeatherRepository;

import java.io.IOException;

public class WeatherUseCase {
    private final WeatherRepository weatherRepository;

    public WeatherUseCase(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Result execute(double latitude, double longitude) {
        return weatherRepository.getWeather(latitude, longitude);
    }
}
