package com.example.domain.useCase;

import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.AirQualityRepo;

public class AirQualityUseCase{

    private final AirQualityRepo repo;

    public AirQualityUseCase(AirQualityRepo repo) {
        this.repo = repo;
    }

    public Result execute(double lat, double lon) {
        return repo.getAirQuality(lat, lon);
    }

}

