package com.example.weatherwoo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.weatherwoo.R;
import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.viewmodel.MainViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    RecyclerView rv_Daily;
    RecyclerView rv_Hourly;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);


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
