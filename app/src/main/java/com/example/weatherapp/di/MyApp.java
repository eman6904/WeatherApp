package com.example.weatherapp.di;

import android.app.Application;

import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

public class MyApp extends Application implements WeatherFragmentDependencies {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public WeatherViewModelFactory provideWeatherViewModelFactory() {
        return appComponent.provideWeatherViewModelFactory();
    }
}



