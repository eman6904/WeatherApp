package com.example.domain.useCase;

import com.example.domain.model.cohereModels.CohereResponse;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.repo.CohereRepo;

public class CohereUseCase {

    private final CohereRepo cohereRepo;

    public CohereUseCase(CohereRepo cohereRepo) {
        this.cohereRepo = cohereRepo;
    }

    public Result execute(String prompt, double temperature) {

        return cohereRepo.getCohereResponse(prompt,temperature);
    }
}
