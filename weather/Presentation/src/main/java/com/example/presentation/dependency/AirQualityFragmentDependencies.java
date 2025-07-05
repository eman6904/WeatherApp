package com.example.presentation.dependency;

import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;

public interface AirQualityFragmentDependencies {
    
    AirQualityViewModelFactory provideAirQualityViewModelFactory();
}
