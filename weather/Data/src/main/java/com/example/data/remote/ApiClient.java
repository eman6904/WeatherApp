package com.example.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static Retrofit createRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static <T> T createService(String baseUrl, Class<T> serviceClass) {
        return createRetrofit(baseUrl).create(serviceClass);
    }
}
