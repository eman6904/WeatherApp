package com.example.data.mapper.weatherMapper;

import com.example.data.model.weatherModels.Hourly;

public class HourlyMapper {
    public static com.example.domain.model.weatherModels.Hourly toDomain(Hourly dataHourly) {
        if (dataHourly == null) return null;

        return new com.example.domain.model.weatherModels.Hourly(
                dataHourly.time,
                dataHourly.temperature_2m,
                dataHourly.weathercode,
                dataHourly.uv_index,
                dataHourly.precipitation
                // ضيف باقي الحقول
        );
    }
}
