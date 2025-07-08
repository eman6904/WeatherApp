package com.example.presentation.utils;

import com.example.presentation.uiModels.AirQualityItems;

import java.util.ArrayList;
import java.util.List;

public class PrepareAirQualityList {

    public static AirQualityItems getList(
            List<Double> pm25List,
            List<Double> pm10List,
            List<Double> coList,
            List<Double> ozoneList
    ) {

            double pm25 = pm25List.get(0);
            double pm10 = pm10List.get(0);
            double co = coList.get(0);
            double ozone = ozoneList.get(0);

            String overall = getOverallStatus(pm25, pm10, ozone, co);

            return new AirQualityItems(
                    overall,
                    "PM2.5: " + pm25 + " → " + getPm25Status(pm25),
                    "PM10: " + pm10 + " → " + getPm10Status(pm10),
                    "CO: " + co + " → " + getCoStatus(co),
                    "Ozone: " + ozone + " → " + getOzoneStatus(ozone)
            );
    }
    private static String getOverallStatus(double pm25, double pm10, double ozone, double co) {
        int dangerScore = 0;

        if (pm25 > 35) dangerScore++;
        if (pm10 > 50) dangerScore++;
        if (ozone > 100) dangerScore++;
        if (co > 300) dangerScore++;

        if (dangerScore >= 3) return "Air is Unhealthy 😷";
        else if (dangerScore == 2) return "Air is Moderate 😊";
        else return "Air is Good 🟢";
    }

    private static String getPm25Status(double value) {
        if (value <= 12) return "Good";
        else if (value <= 35) return "Moderate";
        else return "Unhealthy";
    }

    private static String getPm10Status(double value) {
        if (value <= 50) return "Good";
        else if (value <= 100) return "Moderate";
        else return "Unhealthy";
    }

    private static String getCoStatus(double value) {
        if (value <= 300) return "Safe";
        else return "Unhealthy";
    }

    private static String getOzoneStatus(double value) {
        if (value <= 100) return "Normal";
        else return "High";
    }

}


