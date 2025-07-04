package com.example.weatherapp;

import android.os.Bundle;

import com.example.domain.useCase.WeatherUseCase;
import com.example.weatherapp.databinding.ActivityMainBinding;
import com.example.weatherapp.di.MyApp;

import javax.inject.Inject;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import dagger.internal.DaggerGenerated;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}