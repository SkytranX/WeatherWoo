
package com.example.weatherwoo.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currently {



    @SerializedName("time")
    @Expose
    private Long time;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("icon")
    @Expose
    private String icon;
    @SerializedName("nearestStormDistance")
    @Expose
    private Double nearestStormDistance;
    @SerializedName("nearestStormBearing")
    @Expose
    private Double nearestStormBearing;
    @SerializedName("precipIntensity")
    @Expose
    private Double precipIntensity;
    @SerializedName("precipProbability")
    @Expose
    private Double precipProbability;
    @SerializedName("temperature")
    @Expose
    private Double temperature;
    @SerializedName("apparentTemperature")
    @Expose
    private Double apparentTemperature;
    @SerializedName("dewPoint")
    @Expose
    private Double dewPoint;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("pressure")
    @Expose
    private Double pressure;
    @SerializedName("windSpeed")
    @Expose
    private Double windSpeed;
    @SerializedName("windGust")
    @Expose
    private Double windGust;
    @SerializedName("windBearing")
    @Expose
    private Double windBearing;
    @SerializedName("cloudCover")
    @Expose
    private Double cloudCover;
    @SerializedName("uvIndex")
    @Expose
    private Double uvIndex;
    @SerializedName("visibility")
    @Expose
    private Double visibility;
    @SerializedName("ozone")
    @Expose
    private Double ozone;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(Double nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public Double getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(Double nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public Double getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(Double precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(Double apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public Double getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindGust() {
        return windGust;
    }

    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    public Double getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(Double windBearing) {
        this.windBearing = windBearing;
    }

    public Double getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    public Double getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(Double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getOzone() {
        return ozone;
    }

    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    @Override
    public String toString() {
        return "Currently{" +
                "time=" + time +
                ", summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", nearestStormDistance=" + nearestStormDistance +
                ", nearestStormBearing=" + nearestStormBearing +
                ", precipIntensity=" + precipIntensity +
                ", precipProbability=" + precipProbability +
                ", temperature=" + temperature +
                ", apparentTemperature=" + apparentTemperature +
                ", dewPoint=" + dewPoint +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", windSpeed=" + windSpeed +
                ", windGust=" + windGust +
                ", windBearing=" + windBearing +
                ", cloudCover=" + cloudCover +
                ", uvIndex=" + uvIndex +
                ", visibility=" + visibility +
                ", ozone=" + ozone +
                '}';
    }
}
