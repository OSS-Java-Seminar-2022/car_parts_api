package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String solution;
    @ManyToMany(mappedBy = "issues")
    @JsonIgnore
    private Set<Parts> parts=new HashSet<>();
}
