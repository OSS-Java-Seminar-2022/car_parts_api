package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Users;
import com.example.demo.services.UserService;

@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @RequestMapping(value = "/users", params = "email")
    public ResponseEntity<Users> getByEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(service.getByEmail(email));
    }

    @PostMapping("/users")
    public ResponseEntity<Users> add(@RequestBody Users user)
    {
        return ResponseEntity.ok(service.add(user));
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        service.delete(id);
        return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
    }

}
