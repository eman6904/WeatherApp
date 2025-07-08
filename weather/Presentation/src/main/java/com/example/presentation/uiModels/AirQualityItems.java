package com.example.presentation.uiModels;

public class AirQualityItems {
    public String overallStatus;
    public String pm25;
    public String pm10;
    public String co;
    public String ozone;

    public AirQualityItems( String overallStatus, String pm25, String pm10, String co, String ozone) {

        this.overallStatus = overallStatus;
        this.pm25 = pm25;
        this.pm10 = pm10;
        this.co = co;
        this.ozone = ozone;
    }
}
