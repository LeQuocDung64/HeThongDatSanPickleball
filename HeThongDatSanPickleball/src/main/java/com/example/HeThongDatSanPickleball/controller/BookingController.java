package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.Booking;
import com.example.HeThongDatSanPickleball.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/booking")
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return ResponseEntity.ok("Đặt sân thành công");
    }
}
