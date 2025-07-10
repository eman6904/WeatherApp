package com.example.data.mapper.airQualityMapper;

import com.example.domain.model.airQualityModels.AirQualityResponse;

import java.util.ArrayList;

public class AirQualityResponseMapper {

    public static AirQualityResponse toDomainModel(com.example.data.model.airQualityModels.AirQualityResponse response) {
        if (response != null && response.hourly != null) {
            return new AirQualityResponse(
                    response.hourly.time,
                    response.hourly.pm10,
                    response.hourly.pm2_5,
                    response.hourly.ozone,
                    response.hourly.carbon_monoxide,
                    response.hourly.nitrogen_dioxide,
                    response.hourly.sulphur_dioxide
            );
        } else {
            return new AirQualityResponse(
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>(),
                    new ArrayList<>()
            );
        }
    }
}

