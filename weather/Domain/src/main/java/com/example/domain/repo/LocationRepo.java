package com.example.domain.repo;

import android.util.Pair;

public interface LocationRepo {

    void getCurrentLocation(LocationCallback callback);
    interface LocationCallback {
        void onSuccess(Pair<Double, Double> location);
        void onFailure(String message);
    }
}
