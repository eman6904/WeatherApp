package com.example.domain.model;

public class WeatherResponse {

    private Current current;
    private Hourly hourly;
    private Daily daily;

    public WeatherResponse(Current current, Daily daily, Hourly hourly) {
        this.current = current;
        this.daily = daily;
        this.hourly = hourly;

    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public Hourly getHourly() {
        return hourly;
    }

    public void setHourly(Hourly hourly) {
        this.hourly = hourly;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }
}

