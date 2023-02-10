package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Image;



public interface ImageRepository extends JpaRepository<Image,Integer>{


}
