package com.example.data.mapper;

public class CurrentMapper {
    public static com.example.domain.model.Current toDomain(com.example.data.model.Current dataCurrent) {
        if (dataCurrent == null) return null;

        // هنا بتنسخ الحقول من dataCurrent لـ domainCurrent
        return new com.example.domain.model.Current(
                dataCurrent.time,
                dataCurrent.interval,
                dataCurrent.temperature_2m,
                dataCurrent.weathercode
        );
    }
}
