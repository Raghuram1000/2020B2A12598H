package com.example.RoomManagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private String name;
    private String password;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String email, String name, String password) {
        this.name = name;

        this.password = password;
        this.email = email;


    }



    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail()
    {
        return this.email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.name;
    }


     @Override
    public String toString() {

        return "User(userId=" + id + ", email=" + this.getEmail() + ", name=" + this.getName() + ", password=" + this.getPassword() + ")";
    }
}
