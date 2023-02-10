package com.seminar.WebApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.seminar.WebApp.entities.Car;



@Service
public class UserService {
    
    @Autowired
    RestTemplate restTemplate;


    public String appPage(Model model)
    {

        List<Car> cars = restTemplate.exchange("http://localhost:8080/cars",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Car>>(){}).getBody();
        model.addAttribute("cars", cars);

        return "app";
    }
}
