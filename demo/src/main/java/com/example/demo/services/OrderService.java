package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {
    
    @Autowired
    OrderRepository repository;

    public List<Order> getAll()
    {
        return repository.findAll();
    }

    public Order getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO ORDER PRESENT WITH ID = " + id));
    }

    public Order add(Order order)
    {
        return repository.save(order);
    }
}
