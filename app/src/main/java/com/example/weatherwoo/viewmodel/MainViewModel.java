package com.example.weatherwoo.viewmodel;

import android.app.Application;
import android.database.Observable;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.weatherwoo.model.WeatherResponse;
import com.example.weatherwoo.repository.Repository;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import retrofit2.Call;


public class MainViewModel extends AndroidViewModel {

    private final Repository repo;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repo = Repository.getInstance();
    }


    public Call<WeatherResponse> getWeatherCall(String longitude,String latitude){
        return Repository.getInstance().getWeatherCall(longitude,latitude);
    }
    public Observable<WeatherResponse> getWeatherObservable (String longitude, String latitude){
        return Repository.getInstance().getWeatherObservable(longitude,latitude);
    }
    public Single<WeatherResponse> getWeatherSingle (String longitude, String latitude){
        return Repository.getInstance().getWeatherSingle(longitude,latitude);
    }
    public Maybe<WeatherResponse> getWeatherMaybe (String longitude, String latitude){
        return Repository.getInstance().getWeatherMaybe(longitude,latitude);
    }
    public Flowable<WeatherResponse> getWeatherFlowable (String longitude, String latitude){
        return Repository.getInstance().getWeatherFlowable(longitude,latitude);
    }

}
