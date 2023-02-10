package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
    
    @Query(value="SELECT * FROM users u WHERE u.email=:email",nativeQuery = true)
    Optional<Users> getByEmail(@Param("email")String email);

}
