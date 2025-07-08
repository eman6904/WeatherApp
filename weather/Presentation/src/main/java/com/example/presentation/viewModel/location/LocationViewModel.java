package com.example.presentation.viewModel.location;

import android.util.Pair;

import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.LocationRepo;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LocationViewModel extends ViewModel {

    private final LocationRepo locationRepo;

    @Inject
    public LocationViewModel(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    private final MutableLiveData<Result<Pair<Double, Double>>> locationState = new MutableLiveData<>();
    public LiveData<Result<Pair<Double, Double>>> getLocationState() {
        return locationState;
    }

    public void fetchLocation() {

        locationState.setValue(Result.loading());

        locationRepo.getCurrentLocation(new LocationRepo.LocationCallback2() {
            @Override
            public void onSuccess(Pair<Double, Double> location) {
                locationState.setValue(Result.success(location));
            }

            @Override
            public void onFailure(String message) {
                locationState.setValue(Result.error(message));
            }
        });
    }

}


