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
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.presentation.databinding.FragmentWelcomeScreenBinding;
import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.LocationFragmentDependencies;

import com.example.presentation.dependency.SearchCityFragmentDependencies;
import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.viewModel.airQuality.AirQualityViewModel;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.location.LocationViewModel;
import com.example.presentation.viewModel.location.LocationViewModelFactory;
import com.example.presentation.viewModel.searchCity.SearchCityViewModel;
import com.example.presentation.viewModel.searchCity.SearchCityViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;

import static com.example.domain.model.weatherModels.Result.Status.SUCCESS;


public class WelcomeScreen extends Fragment {
   private FragmentWelcomeScreenBinding binding;
   private LocationViewModel locationViewModel;
   private SearchCityViewModel searchCityViewModel;
    NavController navController;
    public WelcomeScreen() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        provideLocationViewModel(context);
        provideSearchCityViewModel(context);
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

        observeSearchCity();

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCurrentLocation();
               // searchCityViewModel.fetchCityCoordinates("f");
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

    private void provideSearchCityViewModel(Context context) {
        if (context.getApplicationContext() instanceof SearchCityFragmentDependencies) {
            SearchCityViewModelFactory factory =
                    ((SearchCityFragmentDependencies) context.getApplicationContext())
                            .provideSearchCityViewModelFactory();
            searchCityViewModel = new ViewModelProvider(this, factory).get(SearchCityViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();
            searchCityViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory())
                    .get(SearchCityViewModel.class);
        }
    }

    private  void observeLocation(){

        locationViewModel.getLocationState().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                    binding.loadingText.setVisibility(View.VISIBLE);
                    break;

                case SUCCESS: {
                    Bundle bundle = new Bundle();
                    bundle.putDouble("latitude", result.data.first);
                    bundle.putDouble("longitude", result.data.second);
                    navController.navigate(
                            com.example.presentation.R.id.action_welcomeScreen_to_weatherScreen
                            ,bundle
                            , new NavOptions.Builder()
                                    .setPopUpTo( com.example.presentation.R.id.welcomeScreen, true)
                            .build());
                    break;
                }

                case ERROR: {
                    binding.loadingText.setVisibility(View.GONE);
                    Toast.makeText(requireContext(), result.error, Toast.LENGTH_LONG).show();
                }
                    break;
            }
        });
    }
    private void observeSearchCity() {
        searchCityViewModel.getCityLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                    Log.d("WeatherDebug",result.status.toString());

                    break;

                case SUCCESS:
                    Log.d("WeatherDebug",result.data.lat+"");

                    break;

                case ERROR:
                    Log.d("WeatherDebug",result.error);

                    break;
            }
        });
    }


}