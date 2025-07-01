package com.example.data.remote;

public class HttpRoutes {

    private static final String VERSION = "v1";

    private static final String WEATHER_BASE_URL = "https://api.open-meteo.com/" + VERSION;
    private static final String AIR_QUALITY_BASE_URL = "https://air-quality-api.open-meteo.com/" + VERSION;

    public static class ForecastWeather {
        public static final String GET_FORECAST = WEATHER_BASE_URL + "/forecast?";
    }

    public static class AirQuality {
        public static final String GET_AIR_QUALITY = AIR_QUALITY_BASE_URL + "/air-quality?";
    }
}

