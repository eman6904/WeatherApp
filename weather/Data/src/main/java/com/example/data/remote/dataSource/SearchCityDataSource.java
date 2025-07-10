package com.example.data.remote.dataSource;

import com.example.data.model.searchCityModels.SearchCityResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchCityDataSource {
    @GET("search?")
    Call<SearchCityResponse> searchCity(
            @Query("name") String name,
            @Query("count") int count
    );
}
