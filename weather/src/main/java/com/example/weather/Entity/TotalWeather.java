package com.example.weather.Entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TotalWeather {
    private String weather;
    private String weatherDescription;
    private double weatherTemp;
    @NotNull
    @NotEmpty
    @NotBlank
    private String cityName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String country;


}
