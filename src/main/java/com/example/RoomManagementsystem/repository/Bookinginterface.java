package com.example.RoomManagementsystem.repository;

import com.example.RoomManagementsystem.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Bookinginterface extends JpaRepository<BookingEntity,Integer> {
}
