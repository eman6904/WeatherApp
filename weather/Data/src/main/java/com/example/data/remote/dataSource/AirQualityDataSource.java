package com.example.data.remote.dataSource;

import com.example.data.model.airQualityModels.AirQualityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AirQualityDataSource {

    @GET("air-quality")
    Call<AirQualityResponse> getAirQuality(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("hourly") String hourly,
            @Query("timezone") String timezone
    );
}

