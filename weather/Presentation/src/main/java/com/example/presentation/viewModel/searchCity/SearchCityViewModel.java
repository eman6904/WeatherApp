package com.example.presentation.viewModel.searchCity;

import android.os.Handler;
import android.os.Looper;


import com.example.domain.model.SearchCityModels.SearchCityResponse;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.useCase.SearchCityUseCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchCityViewModel extends ViewModel {

    private final SearchCityUseCase searchCityUseCase;

    @Inject
    public SearchCityViewModel(SearchCityUseCase useCase) {
        this.searchCityUseCase = useCase;
    }

    private final MutableLiveData<Result<SearchCityResponse>> cityLiveData = new MutableLiveData<>();
    public LiveData<Result<SearchCityResponse>> getCityLiveData() {
        return cityLiveData;
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void fetchCityCoordinates(String cityName) {
        cityLiveData.postValue(Result.loading());

        executor.execute(() -> {
            Result<SearchCityResponse> result = searchCityUseCase.execute(cityName);
            mainHandler.post(() -> cityLiveData.setValue(result));
        });
    }
}
