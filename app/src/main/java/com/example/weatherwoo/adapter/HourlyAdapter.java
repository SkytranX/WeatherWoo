package com.example.weatherwoo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.HourlyDatum;

import java.sql.Time;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {
    private Context context;
    private List<HourlyDatum> hourlyDataList;

    // Can use this constructor or one below

    public HourlyAdapter(List<HourlyDatum> hourlyDatumList){this.hourlyDataList = hourlyDatumList;}


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
    }

    @Override
    public int getItemCount() { return hourlyDataList.size(); }


    class HourlyViewHolder extends RecyclerView.ViewHolder{
        private ImageView hourlyView;
        private TextView hourlyTemp,hourlyTime;

        public HourlyViewHolder(@NonNull View itemView) {
            super(itemView);
            hourlyView = itemView.findViewById(R.id.ivWeatherIcon);
            hourlyTemp = itemView.findViewById(R.id.tv_temp);
            hourlyTime = itemView.findViewById(R.id.tvTime);


        }

       void setHourlyWeather(HourlyDatum data) {
            String temperature = getRoundedTemp(data.getTemperature());
         //  Toast.makeText(context, temperature, Toast.LENGTH_SHORT).show();

            hourlyTemp.setText(temperature + "\u00B0");
           Time time = new Time(data.getTime());
           String actualTime = String.format("%tI:%tM:%tS %Tp", time.getTime(),time.getTime(),time.getTime(),time.getTime());
           hourlyTime.setText(actualTime);
//           Log.e(temperature, "setHourlyWeather: " );


        }
        String getRoundedTemp(Double temp) {

       /*     Log.e( "setHourlyWeather: ", ""+temp );
            Log.e("setHourlyWeather: ", ""+Math.round(temp) );
            Log.e( "setHourlyWeather: ", String.valueOf(Math.round(temp)) );*/
            return String.valueOf(Math.round(temp));
        }
    }
  }

