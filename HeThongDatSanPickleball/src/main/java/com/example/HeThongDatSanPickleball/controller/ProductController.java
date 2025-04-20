package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.Product;
import com.example.HeThongDatSanPickleball.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepo;

    @GetMapping
    public List<Product> getAll() {
        return productRepo.findAll();
    }
}


