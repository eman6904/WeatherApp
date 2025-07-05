package com.example.weatherapp.di;

import com.example.domain.useCase.WeatherUseCase;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component(modules = {WeatherModule.class, CohereModule.class})
public interface AppComponent {

    WeatherViewModelFactory provideWeatherViewModelFactory();

    CohereViewModelFactory provideCohereViewModelFactory();
}

