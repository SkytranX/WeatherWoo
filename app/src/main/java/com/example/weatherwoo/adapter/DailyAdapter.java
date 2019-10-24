package com.example.weatherwoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwoo.R;
import com.example.weatherwoo.model.Daily;
import com.example.weatherwoo.model.DailyDatum;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.DailyViewHolder> {

    private Context context;
    private List<DailyDatum> dailyDataList;

    // Can use this constructor or one below
    public DailyAdapter(List<DailyDatum> dailyDataList) {
        this.dailyDataList = dailyDataList;
    }

    // Can use this Constructor or one above
    public DailyAdapter(Daily daily) {
        this.dailyDataList = daily.getData();
    }

    @NonNull
    @Override
    public DailyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View theView = LayoutInflater.from(context).inflate(R.layout.daily_item, parent, false);
        return new DailyViewHolder(theView);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyViewHolder holder, int position) {
        DailyDatum data = dailyDataList.get(position);
        holder.setDailyWeather(data);
    }

    @Override
    public int getItemCount() {
        return dailyDataList.size();
    }

    class DailyViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView dailyTime, dailyHigh, dailyLow;
        private ImageView ivWeatherIcon;

        DailyViewHolder(@NonNull View itemView) {
            super(itemView);
            dailyTime = itemView.findViewById(R.id.tvTime);
            dailyHigh = itemView.findViewById(R.id.tvHigh);
            dailyLow = itemView.findViewById(R.id.tvLow);
            ivWeatherIcon = itemView.findViewById(R.id.ivWeatherIcon);
        }

        void setDailyWeather(DailyDatum data) {
            String high = getRoundedTemp(data.getTemperatureHigh());
            String low = getRoundedTemp(data.getTemperatureLow());

            dailyHigh.setText(high);
            dailyLow.setText(low);

        }

        String getRoundedTemp(Double temp) {
            return String.valueOf(Math.round(temp));
        }
    }
}
