package com.example.presentation.viewModel.location;

import android.util.Log;

import com.example.domain.repo.LocationRepo;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LocationViewModelFactory implements ViewModelProvider.Factory {

    private final LocationRepo locationRepo;

    @Inject
    public LocationViewModelFactory(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(LocationViewModel.class)) {
            return (T) new LocationViewModel(locationRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: ");

    }
}

