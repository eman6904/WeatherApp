package com.example.data.remote.dataSourceImp;

import com.example.data.model.cohereModels.CohereRequest;
import com.example.data.model.cohereModels.CohereResponse;
import com.example.data.remote.ApiClient;
import com.example.data.remote.HttpRoutes;
import com.example.data.remote.dataSource.CohereApiDataSource;

import retrofit2.Call;

public class CohereApiDataSourceImpl implements CohereApiDataSource {

    private final CohereApiDataSource api;

    public  CohereApiDataSourceImpl() {
        this.api = ApiClient.createService(HttpRoutes.CohereApi.GET_COHERE_AI_BASE_URL, CohereApiDataSource.class);
    }
    @Override
    public Call<CohereResponse> generateText(CohereRequest request) {
        return api.generateText(request);
    }
}
