package com.example.presentation.screens;


import android.Manifest;
import android.content.Context;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.presentation.databinding.FragmentWelcomeScreenBinding;
import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.LocationFragmentDependencies;

import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.airQuality.AirQualityViewModel;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.location.LocationViewModel;
import com.example.presentation.viewModel.location.LocationViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import static com.example.domain.model.weatherModels.Result.Status.SUCCESS;


public class WelcomeScreen extends Fragment {
   private FragmentWelcomeScreenBinding binding;
   private AirQualityViewModel airQualityViewModel;
   private WeatherViewModel weatherViewModel;
   private LocationViewModel locationViewModel;
    NavController navController;
    public WelcomeScreen() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        provideAirQualityViewModel(context);

        provideWeatherViewModel(context);

        provideLocationViewModel(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false);
        navController = NavHostFragment.findNavController(this);

        observeLocation();

        observeAirQuality();

        observeWeather();

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getCurrentLocation();

            }
        });

        return binding.getRoot();
    }






    private void getCurrentLocation(){
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(requireActivity(),
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        else {
            locationViewModel.fetchLocation();
        }
    }
    private void provideLocationViewModel(Context context){

        if (context.getApplicationContext() instanceof LocationFragmentDependencies) {
            LocationViewModelFactory factory =
                    ((LocationFragmentDependencies) context.getApplicationContext())
                            .provideLocationViewModelFactory();
            locationViewModel = new ViewModelProvider(this, factory).get(LocationViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();

            locationViewModel = new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(LocationViewModel.class);
        }
    }
    private void provideWeatherViewModel(Context context){

        if (context.getApplicationContext() instanceof WeatherFragmentDependencies) {
            WeatherViewModelFactory factory =
                    ((WeatherFragmentDependencies) context.getApplicationContext())
                            .provideWeatherViewModelFactory();
            weatherViewModel = new ViewModelProvider(this, factory).get(WeatherViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();

            weatherViewModel = new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(WeatherViewModel.class);
        }
    }
    private void provideAirQualityViewModel(Context context){

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
    private void observeAirQuality(){

        airQualityViewModel.getAirQualityLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                    Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS:{
                    airQualityViewModel.setAirQualityStatus(true);
                    Log.d("WeatherDebug",result.data.toString());
                    checkAndNavigate();
                    break;
                }

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });
    }
    private void observeWeather(){

        weatherViewModel.getWeatherLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                    Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS: {
                    Log.d("WeatherDebug",result.data.toString());
                    weatherViewModel.setWeatherStatus(true);
                    checkAndNavigate();
                    break;
                }

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });
    }
    private  void observeLocation(){

        locationViewModel.getLocationState().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                    Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS: {

                    airQualityViewModel.fetchAirQuality(result.data.first,result.data.second);

                    weatherViewModel.fetchWeather(result.data.first,result.data.second);

                    Log.d("WeatherDebug",result.data.toString());

                    break;
                }

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });
    }

    private void checkAndNavigate(){

        if(airQualityViewModel.getAirQualityLiveData().getValue().status == SUCCESS &&
                weatherViewModel.getWeatherLiveData().getValue().status == SUCCESS)
        {
            navController.navigate(com.example.presentation.R.id.action_welcomeScreen_to_weatherScreen);
        }
    }


}