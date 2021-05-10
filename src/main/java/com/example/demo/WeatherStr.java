package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class WeatherStr {
   private String city;

    public WeatherStr(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherStr() {
    }


    public String getJSONObj(String urlAdr) throws IOException {
        System.out.println(urlAdr);
        StringBuilder response = new StringBuilder();
        URL url = new URL(urlAdr);
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String line;
        while ((line=bufferedReader.readLine()) != null){
            response.append(line).append("\n");
        }
        bufferedReader.close();
        return response.toString();
    }

    public double getTemp() throws IOException {
        String getusercity = city.trim();
        String output = getJSONObj("http://api.openweathermap.org/data/2.5/weather?q="+getusercity+"&appid=e6eff03fc1602178b2fa0b895a82d5ff&units=metric");
        JSONObject obj = new JSONObject(output);
        return obj.getJSONObject("main").getDouble("temp");
    }

    public List<WeatherItem> getForecast() throws IOException {
        List<WeatherItem> forecastList = new ArrayList<>();
        String getusercity = city.trim();
        String output = getJSONObj("http://api.openweathermap.org/data/2.5/forecast?q="+getusercity+"&lang=ru&appid=e6eff03fc1602178b2fa0b895a82d5ff&units=metric");
        JSONObject obj = new JSONObject(output);
        JSONArray all = obj.getJSONArray("list");
        for (int i = 0; i < 40; i++) {
            JSONObject jsonObject = all.getJSONObject(i);
            forecastList.add(new WeatherItem(jsonObject));
        }

        return forecastList;
    }

    public JSONObject test() throws IOException {
        List<WeatherItem> forecastList = new ArrayList<>();
        String getusercity = city.trim();
        String output = getJSONObj("http://api.openweathermap.org/data/2.5/forecast?q="+getusercity+"&appid=e6eff03fc1602178b2fa0b895a82d5ff&units=metric");
        JSONObject obj = new JSONObject(output);
        return obj.getJSONObject("list.dt");
    }
}
