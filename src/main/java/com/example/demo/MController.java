package com.example.demo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class MController {
    WeatherStr weatherStr = new WeatherStr();

    @GetMapping("/greeting1")
    public String greetingForm(Model model) {
        List<String> map = new ArrayList<>();
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("appContext.xml");
//        WeatherStr weather = context.getBean("weather", WeatherStr.class);
//        model.addAttribute("wtr", weather);
//        try {
//            model.addAttribute("curLocale", LocaleCheck.getCity());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        map.add("YaKI");
        map.add("YabKT");

        return "map";
    }

    @PostMapping("/city")
    public Double greetingSubmit(@RequestBody String city) {
        System.out.println(city);
        StringBuilder sb = new StringBuilder(city);
        sb.deleteCharAt(city.length() - 1);

        WeatherStr wtr = new WeatherStr(sb.toString());
        double temp = 0;
        try {
            temp = wtr.getTemp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(temp);
        return temp;
    }

    @PostMapping("/test")
    public JSONObject te(@RequestBody String city){
        System.out.println(city);
        StringBuilder sb = new StringBuilder(city);


        WeatherStr wtr = new WeatherStr(city);
        JSONObject test = null;
        try {
              test = wtr.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(test);
        return test;
    }

    @PostMapping("/forecast")
    public List<WeatherItem> getForeCast(@RequestBody String city) {
        System.out.println(city);
        StringBuilder sb = new StringBuilder(city);

        sb.deleteCharAt(city.length() - 1);
        WeatherStr wtr = new WeatherStr(sb.toString());
        List<WeatherItem> forecast = null;
        try {
              forecast = wtr.getForecast();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new JSONArray(forecast));

        return forecast;
    }
}