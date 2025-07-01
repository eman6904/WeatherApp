package com.example.data.mapper;

import com.example.domain.model.Daily;
import com.example.domain.model.Hourly;
import com.example.domain.model.Current;
import com.example.domain.model.WeatherResponse;

//if we use kotlin ,instead that we will use extension function
public class WeatherMapper {

    public static com.example.domain.model.WeatherResponse toDomainModel(com.example.data.model.WeatherResponse response) {
        if (response == null) return null;

        com.example.domain.model.Current current = CurrentMapper.toDomain(response.current);
        com.example.domain.model.Daily daily = DailyMapper.toDomain(response.daily);
        com.example.domain.model.Hourly hourly = HourlyMapper.toDomain(response.hourly);

        return new com.example.domain.model.WeatherResponse(current, daily, hourly);
    }
}
