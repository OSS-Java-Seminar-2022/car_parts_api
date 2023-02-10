package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Parts;
import com.example.demo.repositories.PartRepository;

@Service
public class PartService {
    
    @Autowired
    PartRepository repository;


    public List<Parts> getAll()
    {
        return repository.findAll();
    }

    public Parts getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO PART PRESENT WITH ID = " + id));
    }

    public Parts add(Parts part)
    {
        return repository.save(part);
    }

    public List<Parts> findByCarsIdAndIssuesId(int carId,int issueId)
    {
        return repository.findByCarsIdAndIssuesId(carId, issueId);
    }

    public List<Parts> partsPage(int pageNo, int pageSize, String sort)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by(sort));
        Page<Parts> page = repository.findAll(pageable);
        return page.getContent();
    }
}
