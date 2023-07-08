package com.example.weather.Controller;

import com.example.weather.Entity.City;
import com.example.weather.Entity.TotalWeather;
import com.example.weather.Service.CityService;
import com.example.weather.Service.WeatherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
public class WeatherController {

    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherService service;

    @GetMapping("/weather")
    public String getcity(@Valid @NotNull @NotBlank @NotEmpty String cityName, Model model) {
            Optional<City> data = cityService.getData(cityName);

            if (data.isPresent()) {
                City currentCity = data.get();
                TotalWeather currentWeather = service.getWeather(currentCity.getCityName(), currentCity.getCountryName(), currentCity.getLat(), currentCity.getLng());
                model.addAttribute("cityName", currentCity.getCityName());
                model.addAttribute("countryName", currentCity.getCountryName());
                model.addAttribute("weather", currentWeather.getWeather());
                model.addAttribute("weatherTemp", currentWeather.getWeatherTemp());
                model.addAttribute("weatherDisc", currentWeather.getWeatherDescription());
            } else {
                model.addAttribute("errorMessage", "Ooops! City not found");
            }


        return "weather";
    }


}
