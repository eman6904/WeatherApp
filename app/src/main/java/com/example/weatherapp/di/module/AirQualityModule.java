package com.example.weatherapp.di.module;

import com.example.data.remote.dataSource.AirQualityDataSource;
import com.example.data.remote.dataSourceImp.AirQualityDataSourceImpl;
import com.example.data.repoImpl.AirQualityRepositoryImpl;
import com.example.domain.repo.AirQualityRepo;
import com.example.domain.useCase.AirQualityUseCase;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AirQualityModule {

    @Provides
    @Singleton
    public AirQualityDataSource provideAirQualityDataSource() {
        return new AirQualityDataSourceImpl();
    }

    @Provides
    @Singleton
    public AirQualityRepo provideAirQualityRepository(AirQualityDataSource dataSource) {
        return new AirQualityRepositoryImpl(dataSource);
    }

    @Provides
    @Singleton
    public AirQualityUseCase provideAirQualityUseCase(AirQualityRepo repository) {
        return new AirQualityUseCase(repository);
    }

    @Provides
    @Singleton
    public AirQualityViewModelFactory provideAirQualityViewModelFactory(AirQualityUseCase useCase) {
        return new AirQualityViewModelFactory(useCase);
    }
}

