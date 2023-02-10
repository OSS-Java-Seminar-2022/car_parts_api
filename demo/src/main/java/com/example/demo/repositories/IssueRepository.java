package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Issues;

public interface IssueRepository extends JpaRepository<Issues,Integer>{

    List<Issues> findByParts_Id(int partId);
    List<Issues> findIssuesByPartsCarsId(int carId);

}
