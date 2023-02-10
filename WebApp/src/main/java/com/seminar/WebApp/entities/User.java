package com.seminar.WebApp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public boolean hasRole(String roleName) {
        if (this.role.name().equals(roleName)) {
            return true;
        } 
        return false;
        }
    
    }
