package com.example.presentation.screens;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.domain.model.airQualityModels.AirQualityResponse;
import com.example.domain.model.weatherModels.Hourly;
import com.example.domain.model.weatherModels.Result;
import com.example.domain.model.weatherModels.WeatherResponse;
import com.example.presentation.R;
import com.example.presentation.adapter.WeatherAdapter;
import com.example.presentation.databinding.FragmentWeatherScreenBinding;
import com.example.presentation.dependency.AirQualityFragmentDependencies;
import com.example.presentation.dependency.CohereFragmentDependencies;
import com.example.presentation.dependency.WeatherFragmentDependencies;
import com.example.presentation.uiModels.AirQualityItems;
import com.example.presentation.uiModels.WeatherModel;
import com.example.presentation.utils.DateFormatter;
import com.example.presentation.utils.PrepareAirQualityList;
import com.example.presentation.utils.TimeFormatter;
import com.example.presentation.utils.UvIndexDescription;
import com.example.presentation.utils.WeatherHelper;
import com.example.presentation.utils.WeatherIconMapper;
import com.example.presentation.viewModel.CohereApi.CohereViewModel;
import com.example.presentation.viewModel.CohereApi.CohereViewModelFactory;
import com.example.presentation.viewModel.airQuality.AirQualityViewModel;
import com.example.presentation.viewModel.airQuality.AirQualityViewModelFactory;
import com.example.presentation.viewModel.weather.WeatherViewModel;
import com.example.presentation.viewModel.weather.WeatherViewModelFactory;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

import static com.example.domain.model.weatherModels.Result.Status.SUCCESS;
import static com.example.domain.model.weatherModels.Result.Status.valueOf;


public class WeatherScreen extends Fragment {

    private AirQualityViewModel airQualityViewModel;
    private WeatherViewModel weatherViewModel;
    private CohereViewModel aiAdviceViewModel;
    private double lat;
    private double lon;
    private int delay = 0;
    private FragmentWeatherScreenBinding binding;


    public WeatherScreen() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        provideWeatherViewModel(context);
        provideAirQualityViewModel(context);
        provideAiAdviceViewModel(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentWeatherScreenBinding.inflate(inflater, container, false);

        setBottomSheet();

        observeWeather();

        observeAirQuality();

        observeAiAdvice();

        Bundle args = getArguments();
        if (args != null) {
            lat = args.getDouble("latitude", 0.0);
            lon = args.getDouble("longitude", 0.0);

            weatherViewModel.fetchWeather(lat,lon);
            airQualityViewModel.fetchAirQuality(lat,lon);
        }

        return binding.getRoot();
    }

    private void setBottomSheet(){
        BottomSheetBehavior<LinearLayout> behavior = BottomSheetBehavior.from(binding.bottomSheet);

        int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        behavior.setPeekHeight((int) (screenHeight * 0.37));

        behavior.setHideable(false);
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
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
    private void provideAiAdviceViewModel(Context context){

        if (context.getApplicationContext() instanceof CohereFragmentDependencies) {
            CohereViewModelFactory factory =
                    ((CohereFragmentDependencies) context.getApplicationContext())
                            .provideCohereViewModelFactory();
            aiAdviceViewModel = new ViewModelProvider(this, factory).get(CohereViewModel.class);
        } else {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_LONG).show();

            aiAdviceViewModel = new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(CohereViewModel.class);
        }
    }
    private void observeAirQuality(){

        airQualityViewModel.getAirQualityLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING: {
//                    binding.bottomSheetLoadingMode.setVisibility(View.VISIBLE);
//                    binding.bottomSheetContent.setVisibility(View.GONE);
                    break;
                }

                case SUCCESS:{
//                    binding.bottomSheetLoadingMode.setVisibility(View.GONE);
//                    binding.bottomSheetContent.setVisibility(View.VISIBLE);
                    Result weatherStatus = weatherViewModel.getWeatherLiveData().getValue();
                    if(weatherStatus.status == SUCCESS){
                        displayCurrentWeather();
                    }
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

                case LOADING: {
//                    binding.contentLayoutLoadingMode.setVisibility(View.VISIBLE);
//                    binding.contentLayout.setVisibility(View.GONE);
                    break;
                }

                case SUCCESS: {
//                    binding.contentLayoutLoadingMode.setVisibility(View.GONE);
//                    binding.contentLayout.setVisibility(View.VISIBLE);
                    Result airQualityStatus = airQualityViewModel.getAirQualityLiveData().getValue();
                    if(airQualityStatus.status == SUCCESS){
                        displayCurrentWeather();
                    }
                    break;
                }

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });
    }
    private void observeAiAdvice(){

        aiAdviceViewModel.getCohereLiveData().observe(getViewLifecycleOwner(), result -> {
            switch (result.status) {
                case LOADING: {

                    break;
                }

                case SUCCESS:{
                    binding.aiAdviceText.setText(result.data.text);
                    break;
                }

                case ERROR:
                    Log.d("WeatherDebug",result.error);
                    break;
            }
        });
    }
   private List<WeatherModel> getHourlyWeather(Hourly hourly){
       List<WeatherModel> weatherList = new ArrayList<>();
        for(int h = 1;h<=24;h++){

            weatherList.add(new WeatherModel(
                    hourly.temperature_2m.get(h)+" \u00B0C"
                    ,
                    WeatherIconMapper.getIconRes(WeatherHelper.getWeatherDescription(hourly.weathercode.get(h),hourly.temperature_2m.get(h)))
                    , TimeFormatter.convertTo12HourFormat(hourly.time.get(h))));
        }
        return weatherList;
   }
    private void fadeInView(View view, int delay) {
        view.setVisibility(View.VISIBLE);
        Animation fadeIn = AnimationUtils.loadAnimation(requireContext(), R.anim.fade_in);
        fadeIn.setStartOffset(delay);
        view.startAnimation(fadeIn);
        view.setVisibility(View.VISIBLE);
    }

    private void displayCurrentWeather(){

        WeatherResponse weather = weatherViewModel.getWeatherLiveData().getValue().data;
        AirQualityResponse airQuality = airQualityViewModel.getAirQualityLiveData().getValue().data;

        binding.weatherStatusIcon.setImageResource(WeatherIconMapper.getIconRes(WeatherHelper
                .getWeatherDescription(weather.getCurrent().weathercode,weather.getCurrent().temperature_2m)));

        binding.currTemp.setText(weather.getCurrent().temperature_2m+" \u00B0C");

        binding.maxTem.setText("Max: "+ weather.getDaily().temperature_2m_max.get(0) +" \u00B0C");

        binding.minTem.setText("Min: "+ weather.getDaily().temperature_2m_min.get(0) +" \u00B0C");

        binding.today.setText(DateFormatter.formatDate(weather.getCurrent().time));

        fadeInView(binding.home, delay += 100);
        fadeInView(binding.weatherStatusIcon, delay += 100);
        fadeInView(binding.currTemp, delay += 100);
        fadeInView(binding.maxTem, delay += 100);
        fadeInView(binding.minTem, delay += 100);
        fadeInView(binding.todayLayout, delay += 100);
        fadeInView(binding.divider, delay += 100);
        fadeInView(binding.hourlyWeatherLayout, delay += 120);
        fadeInView(binding.airQualityLayout, delay += 120);
        fadeInView(binding.uvLayout, delay+=120);
        fadeInView(binding.sunStatusLayout, delay);
        fadeInView(binding.aiAdvice, delay+=100);


        WeatherAdapter adapter = new WeatherAdapter(getHourlyWeather(weather.getHourly()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false
        );
        binding.forecastRecyclerView.setLayoutManager(layoutManager);
        binding.forecastRecyclerView.setAdapter(adapter);
        binding.right.setOnClickListener(v -> binding.forecastRecyclerView.scrollBy(200, 0));
        binding.left.setOnClickListener(v -> binding.forecastRecyclerView.scrollBy(-200, 0));

        AirQualityItems airQualityDetails = PrepareAirQualityList.getList(
                airQuality.pm2_5,
                airQuality.pm10,
                airQuality.ozone,
                airQuality.carbonMonoxide
        );
        binding.airQualityDes.setText(airQualityDetails.overallStatus);
        binding.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.airQualityDes.setText(airQualityDetails.overallStatus+"\n"
                        +airQualityDetails.pm25+"\n"
                        +airQualityDetails.pm10+"\n"
                        +airQualityDetails.co+"\n"
                        +airQualityDetails.ozone+"\n"
                );

                binding.more.setVisibility(View.GONE);

                binding.less.setVisibility(View.VISIBLE);
            }
        });
        binding.less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                binding.airQualityDes.setText(airQualityDetails.overallStatus);

                binding.more.setVisibility(View.VISIBLE);

                binding.less.setVisibility(View.GONE);
            }
        });

        binding.sunRiseTime.setText(TimeFormatter.convertTo12HourFormat(weather.getDaily().sunrise.get(0)));

        binding.sunsetTime.setText("Sunset: "+TimeFormatter.convertTo12HourFormat(weather.getDaily().sunset.get(0)));

        binding.uvValue.setText(weather.getDaily().uv_index_max.get(0).toString());

        binding.uvDescription.setText(UvIndexDescription.getUvIndexDescription(weather.getDaily().uv_index_max.get(0)));

        binding.uvColor.setColorFilter(UvIndexDescription.getUvColor(weather.getDaily().uv_index_max.get(0)));

        binding.startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aiAdviceViewModel.fetchAIAdvice("The weather is "+
                        WeatherHelper.getWeatherDescription(weather.getCurrent().weathercode,weather.getCurrent().temperature_2m)+
                        " Suggest detailed activities, what to eat and drink, and what to wear using emoji.",
                        0.9
                        );
            }
        });


    }


}