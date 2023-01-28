package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
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
    @OneToMany(targetEntity = Image.class,cascade = CascadeType.ALL)
    @JoinColumn(name="pi_fk",referencedColumnName = "id")
    private List<Image> imageList ;
    private String partDescription;
    @OneToMany(targetEntity = Cars.class,cascade = CascadeType.ALL)
    @JoinColumn(name="pc_fk",referencedColumnName = "id")
    private List<Cars> carsList;
    @ManyToMany
    @JoinTable(name="parts_issues",
                joinColumns =@JoinColumn(name = "partId"),
                inverseJoinColumns =@JoinColumn(name = "issueId"))
    private Set<Issues>setParts=new HashSet<>();

}
