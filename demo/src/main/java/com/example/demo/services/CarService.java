package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Cars;
import com.example.demo.entity.Parts;
import com.example.demo.repositories.CarRepository;

@Service
public class CarService {
    
    @Autowired
    CarRepository repository;

    @Autowired
    PartService partService;

    public List<Cars> getAll()
    {
        return repository.findAll();
    }

    public Cars getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO CAR PRESENT WITH ID = " + id));
    }

    public Cars add(Cars car)
    {
        return repository.save(car);
    }

    public Cars addCarToParts(int partId, int carId)
    {
        Parts part = partService.getById(partId);
        Cars car = getById(carId);
        part.addCar(car);
        partService.add(part);
        return car;
    }


    public List<Cars> carsPage(int pageNo, int pageSize, String sort)
    {
        Pageable pageable = PageRequest.of(pageNo, pageSize,Sort.by(sort));
        Page<Cars> page = repository.findAll(pageable);
        return page.getContent();
    }

}
