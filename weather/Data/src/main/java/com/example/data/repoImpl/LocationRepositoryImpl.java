package com.example.data.repoImpl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.util.Pair;

import com.example.domain.repo.LocationRepo;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import androidx.core.location.LocationManagerCompat;

public class LocationRepositoryImpl implements LocationRepo {

    private final Context appContext;

    public LocationRepositoryImpl(Context context) {
        this.appContext = context.getApplicationContext();
    }

    @Override
    public void getCurrentLocation(LocationCallback2 callback) {

        if (!isLocationEnabled(appContext)) {

            callback.onFailure("Please make sure location services are enabled.");
            return;
        }
        FusedLocationProviderClient fusedLocationClient =
                LocationServices.getFusedLocationProviderClient(appContext);

        fusedLocationClient.getLastLocation()
                .addOnSuccessListener(location -> {
                    if (location != null) {
                        Pair<Double, Double> loc = new Pair<>(location.getLatitude(), location.getLongitude());
                        callback.onSuccess(loc);
                    } else {
                        requestSingleUpdate(callback, fusedLocationClient);
                    }
                })
                .addOnFailureListener(e -> callback.onFailure("Failed to get location"));
    }

    private void requestSingleUpdate(LocationCallback2 callback, FusedLocationProviderClient client) {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setNumUpdates(1);
        locationRequest.setInterval(1000);

        LocationCallback locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult != null && locationResult.getLocations().size() > 0) {
                    Location location = locationResult.getLastLocation();
                    Pair<Double, Double> loc = new Pair<>(location.getLatitude(), location.getLongitude());
                    callback.onSuccess(loc);
                } else {
                    callback.onFailure("Location still not available.");
                }

                client.removeLocationUpdates(this);
            }
        };

        client.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }

    private boolean isLocationEnabled(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return LocationManagerCompat.isLocationEnabled(locationManager);
    }

}

