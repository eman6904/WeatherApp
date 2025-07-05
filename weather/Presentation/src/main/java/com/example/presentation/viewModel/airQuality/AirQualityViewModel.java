package com.example.presentation.viewModel.airQuality;

import android.os.Handler;
import android.os.Looper;

import com.example.domain.model.AirQualityResponse;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.useCase.AirQualityUseCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AirQualityViewModel extends ViewModel {

    private final AirQualityUseCase airQualityUseCase;

    @Inject
    public AirQualityViewModel(AirQualityUseCase airQualityUseCase) {
        this.airQualityUseCase = airQualityUseCase;
    }

    private final MutableLiveData<Result<AirQualityResponse>> airQualityLiveData = new MutableLiveData<>();

    public LiveData<Result<AirQualityResponse>> getAirQualityLiveData() {
        return airQualityLiveData;
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void fetchAirQuality(double lat, double lon) {
        airQualityLiveData.postValue(Result.loading());

        executor.execute(() -> {
            Result<AirQualityResponse> result = airQualityUseCase.execute(lat, lon);

            mainHandler.post(() -> airQualityLiveData.setValue(result));
        });
    }
}

