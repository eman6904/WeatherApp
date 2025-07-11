package com.example.data.repoImpl;

import com.example.data.mapper.SearchCityMapper.SearchCityResponseMapper;
import com.example.data.model.searchCityModels.CityResult;
import com.example.data.model.searchCityModels.SearchCityResponse;
import com.example.data.remote.dataSource.SearchCityDataSource;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.SearchCityRepo;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SearchCityRepositoryImpl implements SearchCityRepo {

    private final SearchCityDataSource dataSource;

    public SearchCityRepositoryImpl(SearchCityDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Result getCityCoordinates(String name) {

        Call<SearchCityResponse> call = dataSource.searchCity(name, 1);
        try {
            Response<SearchCityResponse> response = call.execute();

            if (response.isSuccessful() && response.body() != null && response.body().results != null) {

                List<CityResult> results = response.body().results;

                if (!results.isEmpty()) {

                    return Result.success(SearchCityResponseMapper.mapToDomain(response.body()));

                } else {

                    return Result.error("No cities found");
                }
            } else {

                return Result.error("Something went wrong");
            }
        } catch (IOException e) {

            return Result.error("Check your internet connection");
        }
    }
}

