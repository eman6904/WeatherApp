package com.example.presentation.screens;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.domain.model.weatherModels.WeatherResponse;
import com.example.presentation.databinding.FragmentWelcomeScreenBinding;
import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.CohereApi.CohereViewModel;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModel;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;


public class WelcomeScreen extends Fragment {
   private FragmentWelcomeScreenBinding binding;
   private AirQualityViewModel airQualityViewModel;
    public WelcomeScreen() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context.getApplicationContext() instanceof AirQualityFragmentDependencies) {
            AirQualityViewModelFactory factory =
                    ((AirQualityFragmentDependencies) context.getApplicationContext())
                            .provideAirQualityViewModelFactory();

            airQualityViewModel = new ViewModelProvider(this, factory).get(AirQualityViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();

            airQualityViewModel = new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(AirQualityViewModel.class);
        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false);

        airQualityViewModel.getAirQualityLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                   Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS:
                    Log.d("WeatherDebug",result.data.time.toString());

                    break;

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });

        NavController navController = NavHostFragment.findNavController(this);
        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // navController.navigate(R.id.action_welcomeScreen_to_weatherScreen);
                airQualityViewModel.fetchAirQuality(30.03,31.21);

            }
        });


        return binding.getRoot();
    }

}