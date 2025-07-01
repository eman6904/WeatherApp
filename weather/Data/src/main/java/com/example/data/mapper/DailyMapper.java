package com.example.data.mapper;

public class DailyMapper {
    public static com.example.domain.model.Daily toDomain(com.example.data.model.Daily dataDaily) {
        if (dataDaily == null) return null;

        return new com.example.domain.model.Daily(
                dataDaily.time,
                dataDaily.temperature_2m_max,
                dataDaily.temperature_2m_min,
                dataDaily.sunrise,
                dataDaily.sunset,
                dataDaily.uv_index_max,
                dataDaily.weathercode
                // ضيف باقي الحقول
        );
    }
}
