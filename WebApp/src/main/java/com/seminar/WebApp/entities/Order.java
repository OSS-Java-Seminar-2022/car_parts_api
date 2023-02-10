package com.seminar.WebApp.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    private double price;
    private List<Part> partId = new ArrayList<Part>();
    
    public void addPart(Part part)
    {
        partId.add(part);
    }
}
