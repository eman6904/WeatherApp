package com.example.presentation.utils;

public class AirQualityLevel {
    public static String getAirQualityLevel(double pm2_5) {
        if (pm2_5 <= 12) return "Good - Low Health Risk";
        else if (pm2_5 <= 35.4) return "Moderate - Acceptable Air Quality";
        else if (pm2_5 <= 55.4) return "Unhealthy for Sensitive Groups";
        else if (pm2_5 <= 150.4) return "Unhealthy - Risky Air";
        else if (pm2_5 <= 250.4) return "Very Unhealthy";
        else return "Hazardous - Very Dangerous";
    }
}
