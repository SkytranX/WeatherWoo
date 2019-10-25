package com.example.weatherwoo.adapter;

import android.content.Context;
import android.text.format.DateFormat;
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

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

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
            String day = getDayOfWeek(data.getTime());
            String high = getRoundedTemp(data.getTemperatureHigh());
            String low = getRoundedTemp(data.getTemperatureLow());

            dailyHigh.setText(high+ "\u00B0");
            dailyLow.setText(low+ "\u00B0");
            dailyTime.setText(day);


//            Date date = new Date(data.getTime());
//            String actualTime = String.format(" %tA",date.getTime());
//            dailyTime.setText(actualTime);

        }

        /**
         *this method will convert long into current day in the week
         * @param time takes a long type
         * @return string
         */
        String getDayOfWeek (long time) {
            //INstance Calendar
            Calendar calendar = Calendar.getInstance();
            //set time params
            calendar.setTimeInMillis(time * 1000);
           // using format to extract the current day of the week
            String ans = DateFormat.format("EEEE",calendar).toString();

            return ans;
        }

        String getRoundedTemp(Double temp) {
            return String.valueOf(Math.round(temp));
        }
    }
}
