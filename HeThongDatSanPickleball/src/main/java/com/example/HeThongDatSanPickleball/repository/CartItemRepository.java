package com.example.HeThongDatSanPickleball.repository;

import com.example.HeThongDatSanPickleball.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
