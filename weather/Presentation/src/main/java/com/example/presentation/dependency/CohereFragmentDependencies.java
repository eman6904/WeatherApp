package com.example.presentation.dependency;

import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

public interface CohereFragmentDependencies {

    CohereViewModelFactory provideCohereViewModelFactory();
}
