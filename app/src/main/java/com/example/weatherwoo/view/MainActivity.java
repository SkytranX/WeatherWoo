package com.example.weatherwoo.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.model.ModelLoader;
import com.example.weatherwoo.R;
import com.example.weatherwoo.adapter.DailyAdapter;
import com.example.weatherwoo.adapter.HourlyAdapter;
import com.example.weatherwoo.model.Currently;
import com.example.weatherwoo.model.Daily;
import com.example.weatherwoo.model.Hourly;
import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.viewmodel.MainViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String LATITUDE = "37.3382";
    private static final String LONGITUDE = "-121.8863";

    // Declaring variables
    private MainViewModel viewModel;
    private RecyclerView rvHourly, rvDaily;
    private TextView tvTmp,tvforcast,tvLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing variables
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        rvHourly = findViewById(R.id.rv_hourly);
        setupHourlyRecyclerView();
        rvDaily = findViewById(R.id.rv_daily);
        setupDailyRecyclerView();
        tvforcast = findViewById(R.id.tv_forecast);
        tvTmp = findViewById(R.id.tv_temp);
        tvLocation = findViewById(R.id.tv_city);

        loadWeather();
    }

    private void setupHourlyRecyclerView() {

        rvHourly.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rvHourly.setHasFixedSize(true);
        rvHourly.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void setupDailyRecyclerView() {
        rvDaily.setLayoutManager(new LinearLayoutManager(this));
        rvDaily.setHasFixedSize(true);
        rvDaily.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void loadWeather() {
        viewModel.getWeatherCall(LATITUDE, LONGITUDE)
                .enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                        Toast.makeText(MainActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                        WeatherResponse weatherResponse = response.body();
                        if (weatherResponse != null) {
                            // Load Currently
                            loadCurrently(weatherResponse.getCurrently());
                            // TODO: 10/23/2019
                            // Load Hourly
                            loadHourly(weatherResponse.getHourly());
                            // TODO: 10/23/2019
                            // Load Daily
                            loadDaily(weatherResponse.getDaily());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                        Toast.makeText(MainActivity.this, "FAILURE", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadCurrently(Currently currently) {
        // TODO: 10/23/2019 Pass data into views
        WeatherResponse weatherResponse = new WeatherResponse();
        long tempRound = Math.round(currently.getTemperature());
        String temp = tempRound + "\u00B0";

        tvTmp.setText(temp);

        tvforcast.setText(currently.getSummary());
        tvLocation.setText(weatherResponse.getTimezone());
    }

    private void loadHourly(Hourly hourly) {
        HourlyAdapter h_adapter = new HourlyAdapter(hourly.getData());
        rvHourly.setAdapter(h_adapter);
    }

    private void loadDaily(Daily daily) {
        DailyAdapter adapter = new DailyAdapter(daily.getData());
        rvDaily.setAdapter(adapter);
    }

}

/*        viewModel = ViewModelProviders
                .of(this)
                .get(MainViewModel.class);
        viewModel
                .getWeatherCall(String longitude, String latitude)
                .enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<List<String>> response) {
                        DailyAdapter d_Adapter = new DailyAdapter(response.body());
                        rv_Daily.setAdapter(d_Adapter);
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
                    }
                });*/
//        rv_Daily = findViewById(R.id.rv_daily);
//        rv_Hourly= findViewById(R.id.rv_hourly);
