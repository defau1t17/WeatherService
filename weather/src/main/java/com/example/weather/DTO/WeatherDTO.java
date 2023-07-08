package com.example.weather.DTO;

import lombok.Data;

import java.util.ArrayList;

@Data
public class WeatherDTO {

    private ArrayList<Weather> weather;
    private Temperature main;


}
