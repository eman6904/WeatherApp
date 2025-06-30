package com.example.presentation.screens;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.presentation.R;
import com.example.presentation.adapter.WeatherAdapter;
import com.example.presentation.databinding.FragmentWeatherScreenBinding;
import com.example.presentation.uiModels.WeatherModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class WeatherScreen extends Fragment {
    private FragmentWeatherScreenBinding binding;


    public WeatherScreen() {
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
        binding = FragmentWeatherScreenBinding.inflate(inflater, container, false);


        BottomSheetBehavior<LinearLayout> behavior = BottomSheetBehavior.from(binding.bottomSheet);

        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        behavior.setPeekHeight((int) (screenHeight * 0.37));

        behavior.setHideable(false);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        /////////////////////////////////////////////////////////////////////////
        List<WeatherModel> weatherList = new ArrayList<>();
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic1,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic2,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic7,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic15,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic19,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic13,"Mon"));
        weatherList.add(new WeatherModel("4\u00B0 C",R.drawable.w_ic12,"Mon"));

        WeatherAdapter adapter = new WeatherAdapter(weatherList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false
        );
        binding.forecastRecyclerView.setLayoutManager(layoutManager);
        binding.forecastRecyclerView.setAdapter(adapter);
        binding.right.setOnClickListener(v -> binding.forecastRecyclerView.scrollBy(200, 0));
        binding.left.setOnClickListener(v -> binding.forecastRecyclerView.scrollBy(-200, 0));

        return binding.getRoot();
    }

}