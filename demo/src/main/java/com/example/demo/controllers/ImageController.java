package com.example.demo.controllers;

import java.util.List;

import com.example.demo.entity.Image;
import com.example.demo.services.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ImageController {
    
    @Autowired
    private ImageService service;
    @GetMapping("/images")
    public ResponseEntity<List<Image>> getAll(Model m) {

        return ResponseEntity.ok(service.getAll(m));
    }

    @PostMapping("/images")
    public ResponseEntity<Image> imageUpload(@RequestBody Image image){
        return ResponseEntity.ok(service.add(image));
    }



}
