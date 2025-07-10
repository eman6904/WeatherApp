package com.example.domain.repo;

import com.example.domain.model.weatherModels.Result;

public interface SearchCityRepo {

    Result getCityCoordinates(String name);
}
