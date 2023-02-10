package com.seminar.WebApp.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import com.seminar.WebApp.entities.Car;
import com.seminar.WebApp.entities.Issue;
import com.seminar.WebApp.entities.Part;
import com.seminar.WebApp.services.AdminService;

@Controller
@PreAuthorize("hasAuthority('admin')")
public class AdminController {
    
    @Autowired
    AdminService service;

    @GetMapping("/admin")
    public String admin(Model model)
    {
        return service.admin(model);
    }

    @GetMapping(value = "/admin/cars")
    public String carsList(@RequestParam(value="pageNo") int pageNo,
    @RequestParam(value="pageSize") int pageSize, Model model,
    @RequestParam(value="sort") String sort)
    {
        return service.carsList(pageNo, pageSize, sort, model);
    }

    @GetMapping(value = "/admin/issues")
    public String issueList(@RequestParam(value="pageNo") int pageNo,
    @RequestParam(value="pageSize") int pageSize, Model model,
    @RequestParam(value="sort") String sort)
    {
        return service.issueList(pageNo, pageSize, sort, model);
    }

    @GetMapping(value = "/admin/parts")
    public String partList(@RequestParam(value="pageNo") int pageNo,
    @RequestParam(value="pageSize") int pageSize, Model model,
    @RequestParam(value="sort") String sort)
    {
        return service.partList(pageNo, pageSize, sort, model);
    }



    @PostMapping("/admin/carAdded")
    public RedirectView carAdded(@ModelAttribute Car car)
    {
        return service.carAdded(car);
    }

    @PostMapping("/admin/issueAdded")
    public RedirectView issueAdded(@ModelAttribute Issue issue)
    {
        return service.issueAdded(issue);
    }

    @PostMapping("/admin/partAdded")
    public RedirectView partAdded(@ModelAttribute Part part, @RequestParam MultipartFile img) throws IOException
    {
        return service.partAdded(part,img);
    }

    @PostMapping("/admin/addIssuesToParts")
    public RedirectView addIssuesToParts(@RequestParam(value="partSelect") int partSelect, @RequestParam(value="issueSelect") String issueSelect)
    {
        return service.addIssuesToParts(partSelect,issueSelect);
    }

    @PostMapping("/admin/addCarsToParts")
    public RedirectView addCarsToParts(@RequestParam(value="partSelect") int partSelect, @RequestParam(value="carSelect") String carSelect)
    {
        return service.addCarsToParts(partSelect,carSelect);
    }


}
