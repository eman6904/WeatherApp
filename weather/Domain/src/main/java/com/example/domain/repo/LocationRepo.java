package com.example.domain.repo;

import android.util.Pair;

public interface LocationRepo {

    void getCurrentLocation(LocationCallback2 callback);
    interface LocationCallback2 {
        void onSuccess(Pair<Double, Double> location);
        void onFailure(String message);
    }
}
