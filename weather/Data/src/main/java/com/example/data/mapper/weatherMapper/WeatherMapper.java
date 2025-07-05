package com.example.data.mapper.weatherMapper;

import com.example.domain.model.weatherModels.Current;
import com.example.domain.model.weatherModels.Daily;
import com.example.domain.model.weatherModels.Hourly;
import com.example.domain.model.weatherModels.WeatherResponse;

//if we use kotlin ,instead that we will use extension function
public class WeatherMapper {

    public static WeatherResponse toDomainModel(com.example.data.model.weatherModels.WeatherResponse response) {
        if (response == null) {

            return null;
        }

        Current current = CurrentMapper.toDomain(response.current);
        Daily daily = DailyMapper.toDomain(response.daily);
        Hourly hourly = HourlyMapper.toDomain(response.hourly);

        return new WeatherResponse(current, daily, hourly);
    }
}
