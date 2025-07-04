package com.example.weatherapp.di;

import com.example.domain.useCase.WeatherUseCase;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = {WeatherModule.class})
public interface AppComponent {

    WeatherViewModelFactory provideWeatherViewModelFactory();
}

