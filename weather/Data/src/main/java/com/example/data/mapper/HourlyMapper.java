package com.example.data.mapper;

public class HourlyMapper {
    public static com.example.domain.model.Hourly toDomain(com.example.data.model.Hourly dataHourly) {
        if (dataHourly == null) return null;

        return new com.example.domain.model.Hourly(
                dataHourly.time,
                dataHourly.temperature_2m,
                dataHourly.weathercode,
                dataHourly.uv_index,
                dataHourly.precipitation
                // ضيف باقي الحقول
        );
    }
}
