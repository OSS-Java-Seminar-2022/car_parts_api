package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Parts;

public interface PartRepository extends JpaRepository<Parts,Integer>{

    List<Parts> findByCarsIdAndIssuesId(int carId, int issueId);
}
