package com.example.weather.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class CityDomain {
    private double lng;
    private double lat;
    private String name;
    private String countryName;


}
