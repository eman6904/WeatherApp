package com.example.presentation.viewModel.weather;

import com.example.domain.useCase.WeatherUseCase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class WeatherViewModelFactory implements ViewModelProvider.Factory {

    private final WeatherUseCase weatherUseCase;

    public WeatherViewModelFactory(WeatherUseCase weatherUseCase) {
        this.weatherUseCase = weatherUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WeatherViewModel.class)) {
            return (T) new WeatherViewModel(weatherUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

