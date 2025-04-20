package com.example.HeThongDatSanPickleball.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String courtType;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime bookingTime;

    // Getters
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getCourtType() {
        return courtType;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
