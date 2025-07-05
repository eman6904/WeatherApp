package com.example.presentation.viewModel.airQuality;

import com.example.domain.useCase.AirQualityUseCase;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AirQualityViewModelFactory implements ViewModelProvider.Factory {

    private final AirQualityUseCase airQualityUseCase;

    @Inject
    public AirQualityViewModelFactory(AirQualityUseCase airQualityUseCase) {
        this.airQualityUseCase = airQualityUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AirQualityViewModel.class)) {
            return (T) new AirQualityViewModel(airQualityUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
