package com.example.presentation.dependency;

import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

// واجهة بسيطة بتوصف الاحتياجات من Dagger
public interface WeatherFragmentDependencies {
    WeatherViewModelFactory provideWeatherViewModelFactory();
}
