package com.example.domain.model.SearchCityModels;

public class SearchCityResponse {
    public double lat;
    public double lon;

    public SearchCityResponse(double latitude, double longitude) {
        this.lat = latitude;
        this.lon = longitude;
    }
}
