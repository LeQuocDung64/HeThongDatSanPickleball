package com.example.HeThongDatSanPickleball.repository;

import com.example.HeThongDatSanPickleball.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}

