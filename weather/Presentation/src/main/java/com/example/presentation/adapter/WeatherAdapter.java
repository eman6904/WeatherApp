package com.example.presentation.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.presentation.databinding.WeatherModelBinding;
import com.example.presentation.uiModels.WeatherModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    private List<WeatherModel> weatherList;

    public WeatherAdapter(List<WeatherModel> weatherList) {
        this.weatherList = weatherList;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WeatherModelBinding binding = WeatherModelBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new WeatherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        WeatherModel model = weatherList.get(position);
        holder.binding.weatherTemp.setText(model.getWeatherTemp());
        holder.binding.forecastTime.setText(model.getForecastTime());
        holder.binding.weatherIcon.setImageResource(model.getWeatherIcon());
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        WeatherModelBinding binding;

        public WeatherViewHolder(@NonNull WeatherModelBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
