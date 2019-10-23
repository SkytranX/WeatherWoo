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

import java.util.List;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.weatherViewHolder> {
    private List<DailyDatum> weatherUrls_D;
    private Context context;



    public DailyAdapter(List<DailyDatum> weatherUrls) {
        this.weatherUrls_D = weatherUrls;
    }

    @NonNull
    @Override
    public weatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.daily_item,
                parent,
                false);

        return new weatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull weatherViewHolder holder, int position) {
        DailyDatum dailyForcast = weatherUrls_D.get(position);

        double high = dailyForcast.getTemperatureHigh();
        holder.dailyHigh.setText(String.valueOf(high));
        double low = dailyForcast.getTemperatureLow();
        holder.dailyLow.setText(String.valueOf(low));
        double w_time = dailyForcast.getTime();
        holder.dailyTime.setText(String.valueOf(w_time));



        DailyDatum weatherUrls = weatherUrls_D.get(position);
        Glide.with(context)
                .load(weatherUrls)
                .into(holder.dailyView);
    }

    @Override
    public int getItemCount() {
        return weatherUrls_D.size();
    }

    class weatherViewHolder extends RecyclerView.ViewHolder{
       ImageView dailyView;
       TextView dailyHigh,dailyLow,dailyTime;

        public weatherViewHolder(@NonNull View itemView) {
            super(itemView);
             dailyView = itemView.findViewById(R.id.ivWeatherIcon);
             dailyHigh = itemView.findViewById(R.id.tvHigh);
             dailyLow = itemView.findViewById(R.id.tvLow);
             dailyTime = itemView.findViewById(R.id.tvTime);

        }
    }

}
