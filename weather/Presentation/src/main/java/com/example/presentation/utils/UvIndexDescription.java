package com.example.presentation.utils;

import android.graphics.Color;

public class UvIndexDescription {
    public static String getUvIndexDescription(double uvIndex) {
        if (uvIndex < 3)
            return "Low";
        else if (uvIndex < 6)
            return "Moderate";
        else if (uvIndex < 8)
            return "High";
        else if (uvIndex < 11)
            return "Very High";
        else
            return "Extreme";
    }

    public static int getUvColor(double uvIndex) {
        if (uvIndex < 3)
            return Color.parseColor("#2ECC71");
        else if (uvIndex < 6)
            return Color.parseColor("#F1C40F");
        else if (uvIndex < 8)
            return Color.parseColor("#E67E22");
        else if (uvIndex < 11)
            return Color.parseColor("#E74C3C");
        else
            return Color.parseColor("#8E44AD");
    }
}

