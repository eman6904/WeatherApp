package com.example.domain.repo;

import com.example.domain.model.weatherModels.Result;

public interface AirQualityRepo {
    Result getAirQuality(double lat, double lon);
}
