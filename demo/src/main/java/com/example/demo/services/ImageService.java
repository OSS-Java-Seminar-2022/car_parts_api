package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.entity.Image;
import com.example.demo.repositories.ImageRepository;


@Service
public class ImageService {

    @Autowired
    ImageRepository repository;

    public List<Image> getAll(Model m)
    { 
        return repository.findAll();
    }

    public Image getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO IMAGE PRESENT WITH ID = " + id));
    }

    public Image add(Image image)
    {
        return repository.save(image);
    }

}
