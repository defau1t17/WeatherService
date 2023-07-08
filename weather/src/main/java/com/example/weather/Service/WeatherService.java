package com.example.weather.Service;


import com.example.weather.DTO.WeatherDTO;
import com.example.weather.Entity.TotalWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();

    public TotalWeather getWeather(String cityName, String countryName, double lat, double lot) {
        String WEATHER_REQUEST_URL = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lot + "&units=metric&appid=b57b41432d7075560b8406cea86dea11";
        TotalWeather totalWeather = new TotalWeather();
        try {


            WeatherDTO forObject = restTemplate.getForObject(new URI(WEATHER_REQUEST_URL), WeatherDTO.class);
            totalWeather.setWeather(forObject.getWeather().get(0).getMain());
            totalWeather.setWeatherDescription(forObject.getWeather().get(0).getDescription());
            totalWeather.setWeatherTemp(forObject.getMain().getTemp());
            totalWeather.setCityName(cityName);
            totalWeather.setCountry(countryName);

            System.out.println(countryName);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return totalWeather;
    }


}
