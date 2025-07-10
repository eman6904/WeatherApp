package com.example.presentation.viewModel.searchCity;

import com.example.domain.useCase.SearchCityUseCase;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


import javax.inject.Inject;

public class SearchCityViewModelFactory implements ViewModelProvider.Factory {

    private final SearchCityUseCase searchCityUseCase;

    @Inject
    public SearchCityViewModelFactory(SearchCityUseCase searchCityUseCase) {
        this.searchCityUseCase = searchCityUseCase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(SearchCityViewModel.class)) {
            return (T) new SearchCityViewModel(searchCityUseCase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
