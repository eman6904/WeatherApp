package com.example.data.remote.dataSource;

import com.example.data.model.cohereModels.CohereRequest;
import com.example.data.model.cohereModels.CohereResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CohereApiDataSource {

    @Headers({
            "Authorization: Bearer ziEjHqtIBnkIRwejDvbH1FAcsG9QlXWtEIoAi4Il",
            "Content-Type: application/json"
    })
    @POST("generate")
    Call<CohereResponse> generateText(@Body CohereRequest request);
}
