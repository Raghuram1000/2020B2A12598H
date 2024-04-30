package com.example.RoomManagementsystem.repository;

import com.example.RoomManagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInterface extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
