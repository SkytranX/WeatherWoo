package com.example.weatherwoo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.HourlyDatum;

import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.hourlyViewHolder> {
    private Context context;
    private List<HourlyDatum> hourlyDataList;

    // Can use this constructor or one below
    public HourlyAdapter(List<HourlyDatum> hourlyDataList) {
        this.hourlyDataList = hourlyDataList;
    }


    @NonNull
    @Override
    public hourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View View = LayoutInflater.from(context).inflate(R.layout.daily_item, parent, false);
        return new hourlyViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull hourlyViewHolder holder, int position) {
        HourlyDatum data = hourlyDataList.get(position);

        holder.setHourlyWeather(data);
    }

    @Override
    public int getItemCount() { return hourlyDataList.size(); }


    class hourlyViewHolder extends RecyclerView.ViewHolder{
        ImageView hourlyView;
        TextView hourlyTemp,hourlyTime;

        public hourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            hourlyView = itemView.findViewById(R.id.ivWeatherIcon);
            hourlyTemp = itemView.findViewById(R.id.tv_temp);
            hourlyTime = itemView.findViewById(R.id.tvTime);

        }

       void setHourlyWeather(HourlyDatum data) {
            String temperature = getRoundedTemp(data.getTemperature());
            hourlyTemp.setText(temperature);
        }
        String getRoundedTemp(Double temp) { return String.valueOf(Math.round(temp)); }
    }
  }

