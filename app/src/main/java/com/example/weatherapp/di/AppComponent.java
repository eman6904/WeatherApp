package com.example.weatherapp.di;

import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.location.LocationViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;
import com.example.weatherapp.di.module.AirQualityModule;
import com.example.weatherapp.di.module.CohereModule;
import com.example.weatherapp.di.module.WeatherModule;
import com.example.weatherapp.di.module.locationModule.LocationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {WeatherModule.class, CohereModule.class, AirQualityModule.class, LocationModule.class})
public interface AppComponent {

    WeatherViewModelFactory provideWeatherViewModelFactory();

    CohereViewModelFactory provideCohereViewModelFactory();

    AirQualityViewModelFactory provideAirQualityViewModelFactory();

    LocationViewModelFactory provideLocationViewModelFactory();
}

