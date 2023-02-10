package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repositories.UserRepository;

import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<Users> getAll()
    {
        return repository.findAll();
    }

    public Users getById(int id)
    {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("NO USER PRESENT WITH ID = " + id));
    }

    public Users add(Users user)
    {
        Optional<Users> userB = repository.getByEmail(user.getEmail());
        if(userB.isPresent())
        {
            throw new EntityExistsException("USER WITH THIS EMAIL EXISTS");
        }
        return repository.save(user);
    }

    public Users getByEmail(String email)
    {
        return repository.getByEmail(email).get();
    }
    public void delete (int id){
        repository.deleteById(id);
    }
}
