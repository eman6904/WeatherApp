package com.example.weatherapp.di;

import android.app.Application;

import com.example.domain.useCase.CohereUseCase;
import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

public class MyApp extends Application implements WeatherFragmentDependencies, CohereFragmentDependencies, AirQualityFragmentDependencies {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .weatherModule(new WeatherModule())
                .cohereModule(new CohereModule())
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public WeatherViewModelFactory provideWeatherViewModelFactory() {
        return appComponent.provideWeatherViewModelFactory();
    }

    @Override
    public CohereViewModelFactory provideCohereViewModelFactory() {
        return appComponent.provideCohereViewModelFactory();
    }

    @Override
    public AirQualityViewModelFactory provideAirQualityViewModelFactory() {
        return appComponent.provideAirQualityViewModelFactory();
    }
}



