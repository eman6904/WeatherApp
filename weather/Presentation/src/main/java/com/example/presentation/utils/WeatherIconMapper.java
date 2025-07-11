package com.example.presentation.utils;

import android.util.Log;

import com.example.presentation.R;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WeatherIconMapper {

    public static final Map<String, Integer> descriptionToIconMap;

    static {
        Map<String, Integer> map = new HashMap<>();

        map.put("Clear sky & cold", R.drawable.w_ic15);
        map.put("Clear sky & cool", R.drawable.w_ic15);
        map.put("Clear sky & mild", R.drawable.w_ic15);
        map.put("Clear sky & warm", R.drawable.w_ic15);
        map.put("Clear sky & hot", R.drawable.w_ic15);

        map.put("Mainly clear & cold", R.drawable.w_ic25);
        map.put("Mainly clear & cool", R.drawable.w_ic25);
        map.put("Mainly clear & mild", R.drawable.w_ic25);
        map.put("Mainly clear & warm", R.drawable.w_ic25);
        map.put("Mainly clear & hot", R.drawable.w_ic25);

        map.put("Partly cloudy & cold", R.drawable.w_ic25);
        map.put("Partly cloudy & cool", R.drawable.w_ic25);
        map.put("Partly cloudy & mild", R.drawable.w_ic25);
        map.put("Partly cloudy & warm", R.drawable.w_ic25);
        map.put("Partly cloudy & hot", R.drawable.w_ic25);

        map.put("Cloudy & cold", R.drawable.w_ic23);
        map.put("Cloudy & cool", R.drawable.w_ic23);
        map.put("Cloudy & mild", R.drawable.w_ic23);
        map.put("Cloudy & warm", R.drawable.w_ic25);
        map.put("Cloudy & hot", R.drawable.w_ic25);

        map.put("Foggy & cold", R.drawable.w_ic18);
        map.put("Foggy & cool", R.drawable.w_ic18);
        map.put("Foggy & mild", R.drawable.w_ic18);
        map.put("Foggy & warm", R.drawable.w_ic18);
        map.put("Foggy & hot", R.drawable.w_ic18);

        map.put("Light drizzle & cold", R.drawable.w_ic3);
        map.put("Light drizzle & cool", R.drawable.w_ic3);
        map.put("Light drizzle & mild", R.drawable.w_ic3);
        map.put("Light drizzle & warm", R.drawable.w_ic3);
        map.put("Light drizzle & hot", R.drawable.w_ic3);

        map.put("Rainy & cold", R.drawable.w_ic9);
        map.put("Rainy & cool", R.drawable.w_ic9);
        map.put("Rainy & mild", R.drawable.w_ic9);
        map.put("Rainy & warm", R.drawable.w_ic3);
        map.put("Rainy & hot", R.drawable.w_ic3);

        map.put("Snowy & cold", R.drawable.w_ic7);
        map.put("Snowy & cool", R.drawable.w_ic7);
        map.put("Snowy & mild", R.drawable.w_ic7);
        map.put("Snowy & warm", R.drawable.w_ic11);
        map.put("Snowy & hot", R.drawable.w_ic11);

        map.put("Thunderstorm & cold", R.drawable.w_ic14);
        map.put("Thunderstorm & cool", R.drawable.w_ic14);
        map.put("Thunderstorm & mild", R.drawable.w_ic14);
        map.put("Thunderstorm & warm", R.drawable.w_ic14);
        map.put("Thunderstorm & hot", R.drawable.w_ic14);

        descriptionToIconMap = Collections.unmodifiableMap(map);
    }

    public static int getIconRes(String description) {

        if(descriptionToIconMap.get(description)!=null)
             return descriptionToIconMap.get(description);
        else
            return R.drawable.w_ic25;
    }


}
