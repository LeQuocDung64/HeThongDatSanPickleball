package com.example.HeThongDatSanPickleball.repository;

import com.example.HeThongDatSanPickleball.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
