package com.example.RoomManagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private String roomName;
    private int capacity;

    public RoomEntity() {}

    public RoomEntity(String roomName, int capacity) {
        super();

        this.roomName = roomName;
        this.capacity = capacity;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "RoomEntity(RoomId=" + roomId + ", Capacity=" + this.getCapacity() + ", RoomName=" + this.getRoomName() + ")";
    }
}
