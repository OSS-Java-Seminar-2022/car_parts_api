package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles,Integer>{
    
}
