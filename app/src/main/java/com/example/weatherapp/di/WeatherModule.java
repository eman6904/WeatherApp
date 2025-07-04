package com.example.weatherapp.di;

import com.example.data.remote.dataSource.WeatherDataSource;
import com.example.data.remote.dataSourceImp.WeatherDataSourceImpl;
import com.example.data.repoImpl.WeatherRepositoryImpl;
import com.example.domain.repo.WeatherRepository;
import com.example.domain.useCase.WeatherUseCase;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WeatherModule {

    @Provides
    @Singleton
    public WeatherDataSource provideDataSource() {
        return new WeatherDataSourceImpl();
    }

    @Provides
    @Singleton
    public WeatherRepository provideRepo(WeatherDataSource ds) {
        return new WeatherRepositoryImpl(ds);
    }

    @Provides
    @Singleton
    public WeatherUseCase provideUseCase(WeatherRepository repo) {
        return new WeatherUseCase(repo);
    }

    @Provides
    @Singleton
    public WeatherViewModelFactory provideViewModelFactory(WeatherUseCase useCase) {
        return new WeatherViewModelFactory(useCase);
    }
}

