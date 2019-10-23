package com.example.weatherwoo.repository;

import android.database.Observable;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.repository.remote.RetrofitInstance;
import com.example.weatherwoo.repository.remote.WeatherService;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.Call;

public class Repository {

    private static final String API_KEY = "d3d8fd5a44cc0aa5910d8e7065bb63f7";
    private WeatherService service;

    private Repository() {
        service = RetrofitInstance
                .getInstance()
                .create(WeatherService.class);
    }

    private static final class InstanceHolder {
        private static final Repository INSTANCE = new Repository();
    }

    public static Repository getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public Call<WeatherResponse> getWeatherCall(String longitude, String latitude) {
        return service.getWeatherCall(
                API_KEY,
                longitude,
                latitude
        );
    }

    public Observable<WeatherResponse> getWeatherObservable(String longitude, String latitude) {
        return service.getWeatherObservable(
                API_KEY,
                longitude,
                latitude
        );
    }
    public Single<WeatherResponse> getWeatherSingle(String longitude, String latitude) {
        return service.getWeatherSingle(
                API_KEY,
                longitude,
                latitude
        );
    }
    public Maybe<WeatherResponse> getWeatherMaybe(String longitude, String latitude) {
        return service.getWeatherMaybe(
                API_KEY,
                longitude,
                latitude
        );
    }
    public Flowable<WeatherResponse> getWeatherFlowable(String longitude, String latitude) {
        return service.getWeatherFlowable(
                API_KEY,
                longitude,
                latitude
        );
    }

}