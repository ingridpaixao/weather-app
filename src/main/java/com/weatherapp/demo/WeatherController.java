package com.weatherapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        String apiKey = "fc865712b08677b45d5859865ee6764a"; // Make sure the API key is correct
        String apiUrl = String.format("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric", city, apiKey);

        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(apiUrl, String.class);
        } catch (Exception e) {
            return "{\"error\":\"Unable to fetch weather data. Please check the city name.\"}";
        }
    }
}

