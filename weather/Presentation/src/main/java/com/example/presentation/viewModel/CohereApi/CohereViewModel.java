package com.example.presentation.viewModel.CohereApi;

import android.os.Handler;
import android.os.Looper;

import com.example.domain.model.cohereModels.CohereResponse;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.model.weatherModels.WeatherResponse;
import com.example.domain.useCase.CohereUseCase;
import com.example.domain.useCase.WeatherUseCase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CohereViewModel  extends ViewModel {
    private final CohereUseCase cohereUseCase;
    @Inject
    public CohereViewModel(CohereUseCase useCase) {

        this.cohereUseCase = useCase;
    }
    private final MutableLiveData<Result<CohereResponse>> cohereLiveData = new MutableLiveData<>();
    public LiveData<Result<CohereResponse>> getCohereLiveData() {
        return cohereLiveData;
    }

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    public void fetchAIAdvice(String prompt, double temp) {

        cohereLiveData.postValue(Result.loading());

        executor.execute(() -> {

            Result<CohereResponse> result = cohereUseCase.execute(prompt, temp);

            mainHandler.post(() -> cohereLiveData.setValue(result));

        });
    }
}
