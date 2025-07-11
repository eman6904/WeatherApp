package com.example.data.mapper.cohereApiMapper;

public class CohereResponseMapper {

    public static com.example.domain.model.cohereModels.CohereResponse

    mapToSDomain(com.example.data.model.cohereModels.CohereResponse cohereResponse) {

        if (cohereResponse != null && cohereResponse.text != null) {

            return new com.example.domain.model.cohereModels.CohereResponse(cohereResponse.text);

        } else {

            return new com.example.domain.model.cohereModels.CohereResponse("No response available.");
        }
    }
}
