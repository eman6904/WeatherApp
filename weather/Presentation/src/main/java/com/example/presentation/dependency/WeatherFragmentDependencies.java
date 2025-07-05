package com.example.presentation.dependency;

import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

public interface WeatherFragmentDependencies {
    WeatherViewModelFactory provideWeatherViewModelFactory();
}
