package com.example.presentation.screens;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.presentation.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;


public class WeatherScreen extends Fragment {


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
        View view = inflater.inflate(R.layout.fragment_weather_screen, container, false);

        // ضروري نستخدم view.findViewById عشان احنا جوه Fragment
        LinearLayout bottomSheet = view.findViewById(R.id.bottom_sheet);
        BottomSheetBehavior<LinearLayout> behavior = BottomSheetBehavior.from(bottomSheet);

        // اجعلي الـ Bottom Sheet يبدأ من نصف الشاشة
        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        behavior.setPeekHeight((int) (screenHeight * 0.4));

        // خليه قابل للتمدد عند السحب
        behavior.setHideable(false);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

        return view;
    }

}