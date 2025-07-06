package com.example.data.repoImpl;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;

import com.example.domain.repo.LocationRepo;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import androidx.core.content.ContextCompat;

public class LocationRepositoryImpl implements LocationRepo {

    private final Context appContext;

    public LocationRepositoryImpl(Context context) {
        this.appContext = context.getApplicationContext(); // important!
    }

    @Override
    public void getCurrentLocation(LocationCallback callback) {
        FusedLocationProviderClient fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(appContext);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        Pair<Double, Double> loc = new Pair<>(location.getLatitude(), location.getLongitude());
                        callback.onSuccess(loc);
                    } else {
                        callback.onFailure("Make sure your location services are on.");
                    }
                })
                .addOnFailureListener(e -> callback.onFailure("Failed to get location"));
    }
}

