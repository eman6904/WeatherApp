package com.example.data.repoImpl;

import android.util.Log;

import com.example.data.mapper.cohereApiMapper.CohereResponseMapper;
import com.example.data.model.cohereModels.CohereRequest;
import com.example.data.remote.dataSource.CohereApiDataSource;
import com.example.data.model.cohereModels.CohereResponse;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.CohereRepo;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class CohereRepositoryImpl implements CohereRepo {

    private final CohereApiDataSource dataSource;

    public CohereRepositoryImpl(CohereApiDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Result getCohereResponse(String prompt, double temperature) {

        CohereRequest request = new CohereRequest(prompt,temperature);
        Call<CohereResponse> call = dataSource.generateText(request);
        try {
            Response<CohereResponse> response = call.execute();
            if (response.isSuccessful() && response.body() != null) {
              return Result.success(CohereResponseMapper.mapToSDomain(response.body()));
            } else {

               return Result.error("API Error");
            }
        } catch (IOException e) {

            return Result.error("Network Error");
        }

    }
}
