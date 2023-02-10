package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Roles;
import com.example.demo.services.RoleService;

@RestController
public class RoleController {
    
    @Autowired
    RoleService service;

    @GetMapping("/roles")
    public ResponseEntity<List<Roles>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/roles/{id}")
    public ResponseEntity<Roles> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/roles")
    public ResponseEntity<Roles> add(@RequestBody Roles role)
    {
        return ResponseEntity.ok(service.add(role));
    }
}
