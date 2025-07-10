package com.example.data.mapper.SearchCityMapper;

import com.example.data.model.searchCityModels.CityResult;

public class SearchCityResponseMapper {

    public static com.example.domain.model.SearchCityModels.SearchCityResponse
    mapToDomain(com.example.data.model.searchCityModels.SearchCityResponse dataResponse) {
        if (dataResponse == null || dataResponse.results == null || dataResponse.results.isEmpty()) {
            return new com.example.domain.model.SearchCityModels.SearchCityResponse(0.0, 0.0);
        }

        CityResult city = dataResponse.results.get(0);

        return new com.example.domain.model.SearchCityModels.SearchCityResponse(city.latitude, city.longitude);
    }
}
