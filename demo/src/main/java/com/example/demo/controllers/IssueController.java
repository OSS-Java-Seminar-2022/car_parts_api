package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Issues;
import com.example.demo.services.IssueService;
import com.example.demo.repositories.IssueRepository;

@RestController
@CrossOrigin
public class IssueController {
    
    @Autowired
    IssueService service;

    @Autowired
    IssueRepository test;

    @GetMapping("/issues")
    public ResponseEntity<List<Issues>> getAll()
    {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/issues/{id}")
    public ResponseEntity<Issues> getById(@PathVariable int id)
    {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/issues")
    public ResponseEntity<Issues> add(@RequestBody Issues issue)
    {
        return ResponseEntity.ok(service.add(issue));
    }

    
    @PostMapping("/parts/{partId}/issues/{issueId}")
    ResponseEntity<Issues> addIssueToPart(@PathVariable(value = "partId")int partId,@PathVariable(value="issueId") int issueId)
    {
        return ResponseEntity.ok(service.addIssueToPart(partId,issueId));
    }

    @GetMapping("/issues/parts/{id}")
    public ResponseEntity<List<Issues>> getAllIssuesByPartId(@PathVariable(value="id") int id)
    {
        return ResponseEntity.ok(service.getAllIssuesByPartId(id));
    }
    @GetMapping("/issues/cars/{id}")
    public ResponseEntity<List<Issues>> getAllIssuesByCarId(@PathVariable(value="id") int id)
    {
        return ResponseEntity.ok(service.findIssuesByPartsCarsId(id));
    }

    @GetMapping("/issuespage")
    public ResponseEntity<List<Issues>> carsPage(@RequestParam(name = "pageNo") int pageNo,
    @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "sort") String sort)
    {
        return ResponseEntity.ok(service.issuesPage(pageNo, pageSize, sort));
    }
}
