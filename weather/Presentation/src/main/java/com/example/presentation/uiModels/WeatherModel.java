package com.example.presentation.uiModels;

public class WeatherModel {
    private String weatherTemp;
    private int weatherIcon;
    private String forecastTime;

    public WeatherModel(String temp, int icon, String time) {
        this.weatherTemp = temp;
        this.weatherIcon = icon;
        this.forecastTime = time;
    }

    public String getWeatherTemp() {
        return weatherTemp;
    }

    public int getWeatherIcon() {
        return weatherIcon;
    }

    public String getForecastTime() {
        return forecastTime;
    }

    public void setWeatherTemp(String weatherTemp) {
        this.weatherTemp = weatherTemp;
    }

    public void setWeatherIcon(int weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setForecastTime(String forecastTime) {
        this.forecastTime = forecastTime;
    }
}

