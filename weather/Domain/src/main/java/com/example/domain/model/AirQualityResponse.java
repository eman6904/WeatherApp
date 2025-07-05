package com.example.domain.model;

import java.util.List;

public class AirQualityResponse {
    public final List<String> time;
    public final List<Double> pm10;
    public final List<Double> pm2_5;
    public final List<Double> ozone;

    // بيانات إضافية للـ See More
    public final List<Double> carbonMonoxide;
    public final List<Double> nitrogenDioxide;
    public final List<Double> sulphurDioxide;

    public AirQualityResponse(
            List<String> time,
            List<Double> pm10,
            List<Double> pm2_5,
            List<Double> ozone,
            List<Double> carbonMonoxide,
            List<Double> nitrogenDioxide,
            List<Double> sulphurDioxide
    ) {
        this.time = time;
        this.pm10 = pm10;
        this.pm2_5 = pm2_5;
        this.ozone = ozone;
        this.carbonMonoxide = carbonMonoxide;
        this.nitrogenDioxide = nitrogenDioxide;
        this.sulphurDioxide = sulphurDioxide;
    }
}
