package com.example.weather.DTO;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CityDTO {
    private int totalResultsCount;
    private ArrayList<CityDomain> geonames;
}
