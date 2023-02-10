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
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Parts;
import com.example.demo.services.PartService;

@RestController
@CrossOrigin
public class PartController {
    
    @Autowired
    PartService service;

    @GetMapping("/parts")
    public ResponseEntity<List<Parts>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/parts/{id}")
    public ResponseEntity<Parts> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/parts")
    public ResponseEntity<Parts> add(@RequestBody Parts part)
    {
        return ResponseEntity.ok(service.add(part));
    }

    @GetMapping("parts/cars/{carId}/issues/{issueId}")
    public ResponseEntity<List<Parts>> findByCarsIdAndIssuesId(@PathVariable(value="carId") int carId,@PathVariable(value="issueId") int issueId)
    {
        return ResponseEntity.ok(service.findByCarsIdAndIssuesId(carId, issueId));
    }

    @GetMapping("/partspage")
    public ResponseEntity<List<Parts>> partsPage(@RequestParam(name = "pageNo") int pageNo,
    @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort)
    {
        return ResponseEntity.ok(service.partsPage(pageNo, pageSize, sort));
    }
}
