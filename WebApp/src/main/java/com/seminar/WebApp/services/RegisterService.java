package com.seminar.WebApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.User;


@Service
public class RegisterService {
    
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String register(Model model)
    {
        User userForm = new User();
        model.addAttribute("userForm",userForm);
        return "register";
    }

    public RedirectView registerSuccess(User userForm)
    {
        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
        try{
            restTemplate.postForObject("http://localhost:8080/users", userForm,User.class);
        }catch(Exception e)
        {
                return new RedirectView("/register?error");

        }
        return new RedirectView("/index");
    }

}
