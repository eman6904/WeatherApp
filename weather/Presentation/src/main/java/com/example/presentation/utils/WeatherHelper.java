package com.example.presentation.utils;

public class WeatherHelper {

    public static String getWeatherDescription(int code, double temperature) {
        String description;

        switch (code) {
            case 0:
                description = "Clear sky";
                break;
            case 1:
                description = "Mainly clear";
                break;
            case 2:
                description = "Partly cloudy";
                break;
            case 3:
                description = "Cloudy";
                break;
            case 45:
            case 48:
                description = "Foggy";
                break;
            case 51:
            case 53:
            case 55:
                description = "Light drizzle";
                break;
            case 61:
            case 63:
            case 65:
                description = "Rainy";
                break;
            case 71:
            case 73:
            case 75:
                description = "Snowy";
                break;
            case 95:
                description = "Thunderstorm";
                break;
            default:
                description = "Unknown";
                break;
        }

        if (temperature <= 5) {
            description += " & cold";
        } else if (temperature <= 15) {
            description += " & cool";
        } else if (temperature <= 26) {
            description += " & mild";
        } else if (temperature <= 36) {
            description += " & warm";
        } else {
            description += " & hot";
        }


        return description;
    }
}

