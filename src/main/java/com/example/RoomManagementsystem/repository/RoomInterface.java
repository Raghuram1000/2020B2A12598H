package com.example.RoomManagementsystem.repository;

import com.example.RoomManagementsystem.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomInterface extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> findAllRoomsByCapacity(Integer capacity);
    List<RoomEntity> findByRoomName(String roomName);
}
