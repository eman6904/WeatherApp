package com.example.data.model.weatherModels;

public class WeatherResponse {
    public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public int elevation;
    public CurrentUnits current_units;
    public Current current;
    public HourlyUnits hourly_units;
    public Hourly hourly;
    public DailyUnits daily_units;
    public Daily daily;
}

