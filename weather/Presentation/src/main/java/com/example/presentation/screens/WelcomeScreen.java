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
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class WelcomeScreen extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_welcome_screen, container, false);

        Button btn = view.findViewById(R.id.startBtn);
        NavController navController = NavHostFragment.findNavController(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_welcomeScreen_to_weatherScreen);

            }
        });


        return view;
    }

}