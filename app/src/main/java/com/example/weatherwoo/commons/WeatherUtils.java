package com.example.weatherwoo.commons;

import com.example.weatherwoo.R;

public class WeatherUtils {

    public static int getWeatherIcon(String icon){
        switch (icon) {
            case "clear-day":
                return R.drawable.sun;
            case "clear-night":
                return R.drawable.moon;
            case "partly-cloudy-night":
                return R.drawable.partly_cloudy_night;
            case "partly-cloudy-day":
                return R.drawable.partly_cloudy;
            case "fog":
                return R.drawable.dust;
            case "cloudy":
                return R.drawable.clouds;
            case "rain":
                return R.drawable.rain;

            default:
                return R.drawable.sunny;
        }
    }
}
