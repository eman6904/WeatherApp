package com.example.weatherapp.di;

import com.example.data.remote.HttpRoutes;
import com.example.data.remote.dataSource.CohereApiDataSource;
import com.example.data.remote.dataSource.WeatherDataSource;
import com.example.data.remote.dataSourceImp.CohereApiDataSourceImpl;
import com.example.data.remote.dataSourceImp.WeatherDataSourceImpl;
import com.example.data.repoImpl.CohereRepositoryImpl;
import com.example.domain.repo.CohereRepo;
import com.example.domain.useCase.CohereUseCase;
import com.example.domain.useCase.WeatherUseCase;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CohereModule {

    @Provides
    @Singleton
    public CohereApiDataSource provideDataSource() {
        return new CohereApiDataSourceImpl();
    }

    @Provides
    @Singleton
    public CohereRepo provideCohereRepo(CohereApiDataSource api) {
        return new CohereRepositoryImpl(api);
    }

    @Provides
    @Singleton
    public CohereUseCase provideCohereUseCase(CohereRepo repo) {
        return new CohereUseCase(repo);
    }
    @Provides
    @Singleton
    public CohereViewModelFactory provideCohereViewModelFactory(CohereUseCase useCase) {
        return new CohereViewModelFactory(useCase);
    }
}

