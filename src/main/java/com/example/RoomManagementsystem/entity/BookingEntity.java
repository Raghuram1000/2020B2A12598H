package com.example.RoomManagementsystem.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="bookings")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;

    private String reason;
    private LocalDate date;
    private LocalTime starttime;
    private LocalTime endtime;

    public BookingEntity() {
        // Default constructor
    }

    public BookingEntity(RoomEntity room, String purpose, LocalDate date, LocalTime starttime, LocalTime endtime) {
        this.room = room;
        this.reason = purpose;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    // Getters and setters


    public int getId() {
        return id;
    }



    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }

    public String getPurpose() {
        return reason;
    }

    public void setPurpose(String purpose) {
        this.reason = purpose;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }
    @Override
    public String toString() {
        return "BookingEntity{" +
                "id=" + id +
                ", room=" + this.room +
                ", purpose='" + this.reason + '\'' +
                ", date=" + date +
                ", starttime=" + this.starttime +
                ", endtime=" +this.endtime +
                '}';
    }

}
