package com.seminar.WebApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.User;
import com.seminar.WebApp.services.RegisterService;


@Controller
public class RegisterController {
    
    @Autowired
    RegisterService service;


    @GetMapping("/register")
    public String register(Model model)
    {
        return service.register(model);
    }

    @PostMapping("/register/success")
    public RedirectView registerSucess(@ModelAttribute User userForm)
    {
        return service.registerSuccess(userForm);
    }


}
