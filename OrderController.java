package com.example.pickleball.controller;

import com.example.pickleball.entity.Order;
import com.example.pickleball.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        try {
            orderRepository.save(order);
            return "Đơn hàng đã được lưu vào database!";
        } catch (Exception e) {
            return "Lỗi khi lưu đơn hàng: " + e.getMessage();
        }
    }
}