package com.example.presentation.viewModel.weather;

import android.os.Handler;
import android.os.Looper;

import com.example.domain.model.weatherModels.Result;
import com.example.domain.model.weatherModels.WeatherResponse;
import com.example.domain.useCase.WeatherUseCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WeatherViewModel extends ViewModel {

    private final WeatherUseCase weatherUseCase;
    @Inject
    public WeatherViewModel(WeatherUseCase useCase) {

        this.weatherUseCase = useCase;
    }
    private final MutableLiveData<Result<WeatherResponse>> weatherLiveData = new MutableLiveData<>();
    public LiveData<Result<WeatherResponse>> getWeatherLiveData() {
        return weatherLiveData;
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void fetchWeather(double lat, double lon) {

        weatherLiveData.postValue(Result.loading());

        executor.execute(() -> {

            Result<WeatherResponse> result = weatherUseCase.execute(lat, lon);

            mainHandler.post(() -> weatherLiveData.setValue(result));

        });
    }
}
