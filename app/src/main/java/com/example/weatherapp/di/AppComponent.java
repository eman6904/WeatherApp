package com.example.weatherapp.di;

import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.searchCity.SearchCityViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.location.LocationViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;
import com.example.weatherapp.di.module.AirQualityModule;
import com.example.weatherapp.di.module.CohereModule;
import com.example.weatherapp.di.module.SearchCityModule;
import com.example.weatherapp.di.module.WeatherModule;
import com.example.weatherapp.di.module.LocationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {WeatherModule.class, CohereModule.class, AirQualityModule.class, LocationModule.class, SearchCityModule.class})
public interface AppComponent {

    WeatherViewModelFactory provideWeatherViewModelFactory();

    CohereViewModelFactory provideCohereViewModelFactory();

    AirQualityViewModelFactory provideAirQualityViewModelFactory();

    LocationViewModelFactory provideLocationViewModelFactory();

    SearchCityViewModelFactory provideSearchCityViewModelFactory();
}

