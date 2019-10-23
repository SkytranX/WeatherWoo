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
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.HourlyDatum;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.weatherViewHolder> {
    private Hourly weatherUrls_H;
    private Context context;


    public HourlyAdapter(Hourly weatherUrls) {
        this.weatherUrls_H = weatherUrls;
    }

    @NonNull
    @Override
    public HourlyAdapter.weatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(
                R.layout.daily_item,
                parent,
                false);

        return new HourlyAdapter.weatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull weatherViewHolder holder, int position) {
        HourlyDatum weatherUrls = weatherUrls_H.getData().get(position);
        Glide.with(context)
                .load(weatherUrls)
                .into(holder.dailyView);
    }

    @Override
    public int getItemCount() {
        return weatherUrls_H.getData().size();
    }

    class weatherViewHolder extends RecyclerView.ViewHolder{
        ImageView dailyView;
        TextView dailyTemp,dailyTime;

        public weatherViewHolder(@NonNull View itemView) {
            super(itemView);
            dailyView = itemView.findViewById(R.id.ivWeatherIcon);
            dailyTemp = itemView.findViewById(R.id.tv_temp);
            dailyTime = itemView.findViewById(R.id.tvTime);

        }
    }
}
