package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private double price;
    @OneToMany(targetEntity = Parts.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "op_fk",referencedColumnName = "id")
    private List<Parts> partId;
}
