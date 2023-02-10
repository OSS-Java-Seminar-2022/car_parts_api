package com.seminar.WebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seminar.WebApp.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/app")
    public String appPage(Model model)
    {
        return service.appPage(model);
    }
}
