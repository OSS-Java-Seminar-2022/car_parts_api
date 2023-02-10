package com.seminar.WebApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Part {
    private int id;
    private String name;
    private String domesticMarket;
    private String partDescription;
    private double price;
    private Image image;
    private List<Car> carsList;
    private Set<Issue>setPart;

    public String showImage()
    {
        if(image == null)
            return null;
        return Base64.getEncoder().encodeToString(this.image.getData());
    }

    
}
