package com.example.data.model.cohereModels;

public class CohereRequest {

    private String model ;
    private String prompt;
    private int max_tokens ;
    private double temperature;

    public CohereRequest(String prompt, double temperature) {
        this.prompt = prompt;
        this.temperature = temperature;
        this.model = "command-light";
        this.max_tokens = 250;
    }

    // Getters
    public String getModel() {
        return model;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getMax_tokens() {
        return max_tokens;
    }

    public double getTemperature() {
        return temperature;
    }
}