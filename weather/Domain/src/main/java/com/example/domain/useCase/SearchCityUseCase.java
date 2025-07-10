package com.example.domain.useCase;

import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.SearchCityRepo;

public class SearchCityUseCase {

    SearchCityRepo searchCityRepo;

    public SearchCityUseCase(SearchCityRepo repo) {

        this.searchCityRepo = repo;
    }

   public Result execute(String name){

        return searchCityRepo.getCityCoordinates(name);
    }
}
