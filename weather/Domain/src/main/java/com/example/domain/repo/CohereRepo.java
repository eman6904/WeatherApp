package com.example.domain.repo;

import com.example.domain.model.weatherModels.Result;

public interface CohereRepo {
    Result getCohereResponse(String prompt, double temperature);
}
