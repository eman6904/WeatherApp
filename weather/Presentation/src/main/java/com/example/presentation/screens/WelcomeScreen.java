package com.example.presentation.screens;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.*;
import com.example.presentation.R;
import com.example.presentation.databinding.FragmentWeatherScreenBinding;
import com.example.presentation.databinding.FragmentWelcomeScreenBinding;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


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

        NavController navController = NavHostFragment.findNavController(this);
        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_welcomeScreen_to_weatherScreen);

            }
        });


        return binding.getRoot();
    }

}