package com.example.data.remote.dataSourceImp;

import com.example.data.model.searchCityModels.SearchCityResponse;
import com.example.data.remote.ApiClient;
import com.example.data.remote.HttpRoutes;
import com.example.data.remote.dataSource.SearchCityDataSource;

import retrofit2.Call;

public class SearchCityDataSourceImpl implements SearchCityDataSource {

    SearchCityDataSource api;

    public SearchCityDataSourceImpl() {
        this.api = ApiClient.createService(HttpRoutes.SearchCity.GET_SEARCH_CITY_BASE_URL, SearchCityDataSource.class);
    }

    @Override
    public Call<SearchCityResponse> searchCity(String name, int count) {

        return api.searchCity(name,count);
    }
}
