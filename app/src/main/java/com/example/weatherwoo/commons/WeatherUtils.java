package com.example.weatherwoo.commons;

import com.example.weatherwoo.R;

public class WeatherUtils {

    public static int getWeatherIcon(String icon){
        switch (icon) {
            case "clear_day":
                return 0;
            case "cloudy":
                return 1;

            default:
                return R.drawable.ic_launcher_background;
        }
    }
}
