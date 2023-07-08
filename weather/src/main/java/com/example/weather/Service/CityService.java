package com.example.weather.Service;

import com.example.weather.DTO.CityDTO;
import com.example.weather.Entity.City;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Service
public class CityService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<City> getData(String cityName) {
        String CITY_REQUEST_URL = "http://api.geonames.org/searchJSON?q=" + cityName + "&maxRows=1&username=michaelka";
        City city = new City();
        try {

            CityDTO forObject = restTemplate.getForObject(new URI(CITY_REQUEST_URL), CityDTO.class);
            if (forObject.getTotalResultsCount() == 0) {
                System.out.println("error found");
                return Optional.empty();
            } else {
                city.setCityName(cityName);
                city.setCountryName(forObject.getGeonames().get(0).getCountryName());
                city.setLat(forObject.getGeonames().get(0).getLat());
                city.setLng(forObject.getGeonames().get(0).getLng());
            }

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(city);
    }


}
