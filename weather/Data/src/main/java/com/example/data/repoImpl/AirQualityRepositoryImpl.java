package com.example.data.repoImpl;

import com.example.data.mapper.airQualityMapper.AirQualityResponseMapper;
import com.example.data.model.airQualityModels.AirQualityResponse;
import com.example.data.remote.dataSource.AirQualityDataSource;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.AirQualityRepo;

import java.io.IOException;

import retrofit2.Response;

public class AirQualityRepositoryImpl implements AirQualityRepo {

    private final AirQualityDataSource dataSource;

    public AirQualityRepositoryImpl(AirQualityDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Result getAirQuality(double lat, double lon) {
        try {
            Response<AirQualityResponse> response = dataSource.getAirQuality(
                    lat,
                    lon,
                    "pm10,pm2_5,carbon_monoxide,ozone,nitrogen_dioxide,sulphur_dioxide",
                    "Africa/Cairo"
            ).execute();

            if (response.isSuccessful() && response.body() != null) {
                return Result.success(AirQualityResponseMapper.toDomainModel(response.body()));
            } else {
                return Result.error("API error");
            }

        } catch (IOException e) {
            return Result.error("Network error");
        }
    }
}

