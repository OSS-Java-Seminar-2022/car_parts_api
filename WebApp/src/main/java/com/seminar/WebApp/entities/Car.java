package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {

    private int id;
    private String manufacturer;
    private String model;
    private String domesticMarket;
    private int year;
    
}
