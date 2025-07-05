package com.example.presentation.viewModel.CohereApi;

import com.example.domain.useCase.CohereUseCase;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CohereViewModelFactory implements ViewModelProvider.Factory {
    private final CohereUseCase cohereUseCase;

    @Inject
    public CohereViewModelFactory(CohereUseCase cohereUseCase) {
        this.cohereUseCase = cohereUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CohereViewModel.class)) {
            return (T) new CohereViewModel(cohereUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
