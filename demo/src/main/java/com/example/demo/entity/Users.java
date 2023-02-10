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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @OneToMany(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name="uo_fk",referencedColumnName = "id")
    private List<Order> orderList;
    //@OneToOne(targetEntity = Roles.class,cascade = CascadeType.ALL)
    //@JoinColumn(name="ur_fk",referencedColumnName = "id")
    //private int roleid;
    private String role;

}
