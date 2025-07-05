package com.example.data.remote.dataSourceImp;

import com.example.data.model.airQualityModels.AirQualityResponse;
import com.example.data.remote.ApiClient;
import com.example.data.remote.HttpRoutes;
import com.example.data.remote.dataSource.AirQualityDataSource;

import retrofit2.Call;

public class AirQualityDataSourceImpl implements AirQualityDataSource {

    private AirQualityDataSource api;

    public AirQualityDataSourceImpl(){

        this.api = ApiClient.createService(HttpRoutes.AirQuality.GET_AIR_QUALITY, AirQualityDataSource.class);
    }
    @Override
    public Call<AirQualityResponse> getAirQuality(double latitude, double longitude, String hourly, String timezone) {
        return api.getAirQuality(latitude,longitude,hourly,timezone);
    }
}
