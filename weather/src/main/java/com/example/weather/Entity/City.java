package com.example.weather.Entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class City {
    @NotNull
    @NotEmpty
    @NotBlank
    private String cityName;
    @NotNull
    @NotEmpty
    @NotBlank
    private String countryName;
    private double lng;
    private double lat;


}
