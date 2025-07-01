package com.example.presentation.screens;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.data.remote.WeatherDataSourceImpl;
import com.example.data.repoImpl.WeatherRepositoryImpl;
import com.example.domain.model.WeatherResponse;
import com.example.domain.useCase.WeatherUseCase;
import com.example.presentation.R;
import com.example.presentation.databinding.FragmentWelcomeScreenBinding;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;


public class WelcomeScreen extends Fragment {
   private FragmentWelcomeScreenBinding binding;

    public WelcomeScreen() {
        // Required empty public constructor
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

        WeatherUseCase useCase = new WeatherUseCase(new WeatherRepositoryImpl(new WeatherDataSourceImpl()));
        WeatherViewModelFactory factory = new WeatherViewModelFactory(useCase);
        WeatherViewModel viewModel = new ViewModelProvider(this, factory).get(WeatherViewModel.class);

        viewModel.getWeatherLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                   Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS:
                    Log.d("WeatherDebug",result.data.getCurrent().time);
                    WeatherResponse data = result.data;
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
                viewModel.fetchWeather(30.03, 31.21);

            }
        });


        return binding.getRoot();
    }

}