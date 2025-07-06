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

import com.example.presentation.dependency.LocationFragmentDependencies;


import com.example.presentation.viewModel.location.LocationViewModel;
import com.example.presentation.viewModel.location.LocationViewModelFactory;


public class WelcomeScreen extends Fragment {
   private FragmentWelcomeScreenBinding binding;
   private LocationViewModel viewModel;
    public WelcomeScreen() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context.getApplicationContext() instanceof LocationFragmentDependencies) {
            LocationViewModelFactory factory =
                    ((LocationFragmentDependencies) context.getApplicationContext())
                            .provideLocationViewModelFactory();
            viewModel = new ViewModelProvider(this, factory).get(LocationViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();

            viewModel = new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(LocationViewModel.class);
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

        viewModel.getLocationState().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING:
                   Log.d("WeatherDebug",result.status.toString());
                    break;

                case SUCCESS:
                    Log.d("WeatherDebug",result.data.toString());

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
            viewModel.fetchLocation();
        }
    }

}