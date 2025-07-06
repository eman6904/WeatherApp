package com.example.weatherapp.di.module.locationModule;

import android.content.Context;

import com.example.data.repoImpl.LocationRepositoryImpl;
import com.example.domain.repo.LocationRepo;
import com.example.presentation.viewModel.location.LocationViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class LocationModule {

    private final Context context;

    public LocationModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @Singleton
    public LocationRepo provideLocationRepo() {
        return new LocationRepositoryImpl(context);
    }

    @Provides
    @Singleton
    public LocationViewModelFactory provideLocationViewModelFactory(LocationRepo locationRepo) {
        return new LocationViewModelFactory(locationRepo);
    }
}

