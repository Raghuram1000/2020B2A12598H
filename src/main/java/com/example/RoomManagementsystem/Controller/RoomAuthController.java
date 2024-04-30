package com.example.RoomManagementsystem.Controller;

import com.example.RoomManagementsystem.entity.RoomEntity;
import com.example.RoomManagementsystem.repository.RoomInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class RoomAuthController {
    @Autowired
    RoomInterface roomInterface;

    public RoomAuthController() {
    }

    @GetMapping("/rooms")
    public ResponseEntity<?> allRooms(@RequestParam(defaultValue = "0") Integer capacity) {
        try {
            capacity = Math.max(capacity, 0);
            List<RoomEntity> allRooms = roomInterface.findAllRoomsByCapacity(capacity);
            return ResponseEntity.status(HttpStatus.OK).body(allRooms);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Rooms API Error");
        }
    }

    @PostMapping("/rooms")
    public ResponseEntity<?> addRoom(@RequestBody Map<String, Object> room) {
        try {
            String roomName = room.get("roomName").toString();
            Integer roomCapacity = (Integer) room.get("roomCapacity");

            if (roomCapacity < 0) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Invalid capacity");
            }

            List<RoomEntity> foundRooms = roomInterface.findByRoomName(roomName);
            if (!foundRooms.isEmpty()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Room already exists");
            }

            RoomEntity newRoom = new RoomEntity(roomName, roomCapacity);
            RoomEntity savedRoom = roomInterface.save(newRoom);
            return ResponseEntity.status(HttpStatus.OK).body("Room created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Rooms API Error");
        }
    }
}
