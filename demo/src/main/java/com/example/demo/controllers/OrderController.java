package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;

@RestController
public class OrderController {
    
    @Autowired
    OrderService service;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> add(@RequestBody Order role)
    {
        return ResponseEntity.ok(service.add(role));
    }
}
