package com.example.data.mapper.weatherMapper;

import com.example.data.model.weatherModels.Current;

public class CurrentMapper {

    public static com.example.domain.model.weatherModels.Current toDomain(Current dataCurrent) {

        if (dataCurrent == null) return null;

        return new com.example.domain.model.weatherModels.Current(

                dataCurrent.time,
                dataCurrent.interval,
                dataCurrent.temperature_2m,
                dataCurrent.weathercode
        );
    }
}
