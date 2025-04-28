package com.example.pickleball.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false, columnDefinition = "TEXT")
    private String address;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @Column(name = "order_details", nullable = false, columnDefinition = "TEXT")
    private String orderDetails;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}