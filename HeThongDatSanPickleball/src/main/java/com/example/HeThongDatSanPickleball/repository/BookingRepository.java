package com.example.HeThongDatSanPickleball.repository;

import com.example.HeThongDatSanPickleball.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
