package com.example.presentation.utils;

import com.example.presentation.R;

import java.util.HashMap;
import java.util.Map;

public class WeatherIconMapper {

    private static final Map<Integer, Integer> weatherCodeToIcon = new HashMap<>();

    static {
        weatherCodeToIcon.put(0, R.drawable.w_ic15);
        weatherCodeToIcon.put(1, R.drawable.w_ic25);
        weatherCodeToIcon.put(2, R.drawable.w_ic25);
        weatherCodeToIcon.put(3, R.drawable.w_ic23);
        weatherCodeToIcon.put(45, R.drawable.w_ic20);
        weatherCodeToIcon.put(48, R.drawable.w_ic20);
        weatherCodeToIcon.put(51, R.drawable.w_ic9);
        weatherCodeToIcon.put(53, R.drawable.w_ic9);
        weatherCodeToIcon.put(55, R.drawable.w_ic9);
        weatherCodeToIcon.put(56, R.drawable.w_ic7);
        weatherCodeToIcon.put(57, R.drawable.w_ic7);
        weatherCodeToIcon.put(61, R.drawable.w_ic9);
        weatherCodeToIcon.put(63, R.drawable.w_ic9);
        weatherCodeToIcon.put(65, R.drawable.w_ic2);
        weatherCodeToIcon.put(66, R.drawable.w_ic17);
        weatherCodeToIcon.put(67, R.drawable.w_ic17);
        weatherCodeToIcon.put(71, R.drawable.w_ic7);
        weatherCodeToIcon.put(73, R.drawable.w_ic7);
        weatherCodeToIcon.put(75, R.drawable.w_ic4);
        weatherCodeToIcon.put(77, R.drawable.w_ic7);
        weatherCodeToIcon.put(80, R.drawable.w_ic3);
        weatherCodeToIcon.put(81, R.drawable.w_ic3);
        weatherCodeToIcon.put(82, R.drawable.w_ic14);
        weatherCodeToIcon.put(85, R.drawable.w_ic4);
        weatherCodeToIcon.put(86, R.drawable.w_ic4);
        weatherCodeToIcon.put(95, R.drawable.w_ic13);
        weatherCodeToIcon.put(96, R.drawable.w_ic14);
        weatherCodeToIcon.put(99, R.drawable.w_ic14);
    }

    public static int getIconResource(int weatherCode) {

       return weatherCodeToIcon.get(weatherCode);

    }


}
