package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WeatherItem {
    private Date date;
    private Map<String, String> currWeather;
    private double temp;
    private double windSpeed;

    public WeatherItem() {
    }


    public WeatherItem(JSONObject jsonObject) {
        currWeather = new HashMap<>();
        temp = jsonObject.getJSONObject("main").getDouble("temp");
        setCurrWeather(jsonObject.getJSONArray("weather"));
        windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");
        setDate(jsonObject.getString("dt_txt"));
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            this.date = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> getCurrWeather() {
        return currWeather;
    }

    public void setCurrWeather(JSONArray currWeather) {
        this.currWeather.put("main", currWeather.getJSONObject(0).getString("main"));
        this.currWeather.put("description", currWeather.getJSONObject(0).getString("description"));
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }


    @Override
    public String toString() {
        return "WeatherItem{" +
                "date=" + date +
                ", currWeather=" + currWeather +
                ", temp=" + temp +
                ", windSpeed=" + windSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherItem that = (WeatherItem) o;
        return Double.compare(that.temp, temp) == 0 &&
                Double.compare(that.windSpeed, windSpeed) == 0 &&
                Objects.equals(date, that.date) &&
                Objects.equals(currWeather, that.currWeather);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, currWeather, temp, windSpeed);
    }
}
