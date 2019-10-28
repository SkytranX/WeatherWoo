package com.example.weatherwoo.adapter;

import android.content.Context;
import android.text.format.DateFormat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weatherwoo.R;
import com.example.weatherwoo.commons.WeatherUtils;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.HourlyDatum;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {
    private Context context;
    private List<HourlyDatum> hourlyDataList;

    // Can use this constructor or one below

    public HourlyAdapter(List<HourlyDatum> hourlyDatumList) {
        this.hourlyDataList = hourlyDatumList;
    }


    @NonNull
    @Override
    public HourlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View View = LayoutInflater.from(context).inflate(R.layout.hourly_item, parent, false);
        return new HourlyViewHolder(View);
    }

    @Override
    public void onBindViewHolder(@NonNull HourlyViewHolder holder, int position) {
        HourlyDatum data = hourlyDataList.get(position);
        holder.setHourlyWeather(data);

        int icon = WeatherUtils.getWeatherIcon(data.getIcon());


        Glide.with(context).load(icon).into(holder.hourlyView);
    }

    @Override
    public int getItemCount() {
        return hourlyDataList.size();
    }


    class HourlyViewHolder extends RecyclerView.ViewHolder {
        private ImageView hourlyView;
        private TextView hourlyTemp, hourlyTime;

        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            hourlyView = itemView.findViewById(R.id.ivWeatherIcon);
            hourlyTemp = itemView.findViewById(R.id.tv_temp);
            hourlyTime = itemView.findViewById(R.id.tvTime);


        }

        void setHourlyWeather(HourlyDatum data) {

            String temperature = getRoundedTemp(data.getTemperature());
            //  Toast.makeText(context, temperature, Toast.LENGTH_SHORT).show();
            //  Log.e(data.getIcon(), "setHourlyWeather: " );
            hourlyTemp.setText(temperature + "\u00B0");

            //Option #1
            //String hour = getHourOfDay(data.getTime());
            //hourlyTime.setText(hour);


            //Option #2
            long a_time = data.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("ha", Locale.getDefault());
            String hourly_Time = sdf.format(a_time * 1000);
            hourlyTime.setText(hourly_Time);

        }

        String getHourOfDay(long time) {
            //INstance Calendar
            Calendar calendar = Calendar.getInstance();
            //set time params
            calendar.setTimeInMillis(time * 1000);
            // using format to extract the current day of the week
            String ans = DateFormat.format("h:mm a", calendar).toString();
            return ans;
        }

        String getRoundedTemp(Double temp) {

       /*     Log.e( "setHourlyWeather: ", ""+temp );
            Log.e("setHourlyWeather: ", ""+Math.round(temp) );
            Log.e( "setHourlyWeather: ", String.valueOf(Math.round(temp)) );*/
            return String.valueOf(Math.round(temp));
        }

    }
}

