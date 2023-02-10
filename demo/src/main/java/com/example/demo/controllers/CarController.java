package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cars;
import com.example.demo.services.CarService;

@RestController
public class CarController {
    
    @Autowired
    CarService service;

    @GetMapping("/cars")
    public ResponseEntity<List<Cars>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Cars> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Cars> add(@RequestBody Cars car)
    {
        return ResponseEntity.ok(service.add(car));
    }

    @PostMapping("/parts/{partId}/cars/{carId}")
    public ResponseEntity<Cars> addCarToParts(@PathVariable(value="partId") int partId,@PathVariable(value="carId") int carId)
    {
        return ResponseEntity.ok(service.addCarToParts(partId,carId));
    }

    
    @GetMapping("/carspage")
    public ResponseEntity<List<Cars>> carsPage(@RequestParam(name = "pageNo") int pageNo,
    @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort)
    {
        return ResponseEntity.ok(service.carsPage(pageNo, pageSize, sort));
    }



}
