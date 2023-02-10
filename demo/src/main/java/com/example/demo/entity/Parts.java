package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String domesticMarket;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pi_fk")
    private Image image;
    private String partDescription;
    @ManyToMany
    @JoinTable(name="part_cars",
                joinColumns =@JoinColumn(name = "part_id"),
                inverseJoinColumns =@JoinColumn(name = "car_id"))
    @JsonIgnore
    private Set<Cars>cars=new HashSet<>();

    @ManyToMany
    @JoinTable(name="parts_issues",
                joinColumns =@JoinColumn(name = "part_id"),
                inverseJoinColumns =@JoinColumn(name = "issue_id"))
    @JsonIgnore
    private Set<Issues>issues=new HashSet<>();

    public void addIssue(Issues issue)
    {
        issues.forEach(i -> {
            if(i.getId() == issue.getId())
            {
                throw new EntityExistsException("Issue is already added");
            }
        });
        issues.add(issue);
        issue.getParts().add(this);
    }

    public void addCar(Cars car)
    {
        cars.forEach(c -> {
            if(c.getId() == car.getId())
            {
                throw new EntityExistsException("Car is already added");
            }
        });
        cars.add(car);
        car.getParts().add(this);
    }


}


