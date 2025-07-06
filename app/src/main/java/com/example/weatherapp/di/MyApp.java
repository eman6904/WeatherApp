package com.example.weatherapp.di;

import android.app.Application;

import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.dependency.LocationFragmentDependencies;
import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.location.LocationViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;
import com.example.weatherapp.di.module.AirQualityModule;
import com.example.weatherapp.di.module.CohereModule;
import com.example.weatherapp.di.module.WeatherModule;
import com.example.weatherapp.di.module.locationModule.LocationModule;

public class MyApp extends Application implements WeatherFragmentDependencies, CohereFragmentDependencies, AirQualityFragmentDependencies, LocationFragmentDependencies {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .weatherModule(new WeatherModule())
                .cohereModule(new CohereModule())
                .airQualityModule(new AirQualityModule())
                .locationModule(new LocationModule(this))
                .build();
    }

    @Override
    public WeatherViewModelFactory provideWeatherViewModelFactory() {
        return appComponent.provideWeatherViewModelFactory();
    }

    @Override
    public CohereViewModelFactory provideCohereViewModelFactory() {
        return appComponent.provideCohereViewModelFactory();
    }

    @Override
    public AirQualityViewModelFactory provideAirQualityViewModelFactory() {
        return appComponent.provideAirQualityViewModelFactory();
    }
    @Override
    public LocationViewModelFactory provideLocationViewModelFactory() {
        return appComponent.provideLocationViewModelFactory();
    }
}



