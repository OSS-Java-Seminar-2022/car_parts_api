package com.seminar.WebApp.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class IndexService {

    public String index(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("role", auth.getAuthorities().iterator().next().getAuthority());
        return "index";
    }
    
}
