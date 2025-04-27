package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.Booking;
import com.example.HeThongDatSanPickleball.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        bookingRepository.save(booking);
        return ResponseEntity.ok("Đặt sân thành công");
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok(bookings);
    }
}
