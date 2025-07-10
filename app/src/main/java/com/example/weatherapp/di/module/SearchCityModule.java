package com.example.weatherapp.di.module;

import com.example.data.remote.dataSource.SearchCityDataSource;
import com.example.data.remote.dataSourceImp.SearchCityDataSourceImpl;
import com.example.data.repoImpl.SearchCityRepositoryImpl;
import com.example.domain.repo.SearchCityRepo;
import com.example.domain.useCase.SearchCityUseCase;
import com.example.presentation.viewModel.searchCity.SearchCityViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class SearchCityModule {
    @Provides
    @Singleton
    public SearchCityDataSource provideDataSource() {
        return new SearchCityDataSourceImpl();
    }

    @Provides
    @Singleton
    public SearchCityRepo provideRepo(SearchCityDataSource ds) {
        return new SearchCityRepositoryImpl(ds);
    }

    @Provides
    @Singleton
    public SearchCityUseCase provideUseCase(SearchCityRepo repo) {
        return new SearchCityUseCase(repo);
    }

    @Provides
    @Singleton
    public SearchCityViewModelFactory provideViewModelFactory(SearchCityUseCase useCase) {
        return new SearchCityViewModelFactory(useCase);
    }
}
