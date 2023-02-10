package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Roles;
import com.example.demo.repositories.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    RoleRepository repository;

    public List<Roles> getAll()
    {
        return repository.findAll();
    }

    public Roles getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO ROLE PRESENT WITH ID = " + id));
    }

    public Roles add(Roles role)
    {
        return repository.save(role);
    }
}
