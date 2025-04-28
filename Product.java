package com.example.pickleball.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "is_new")
    private Boolean isNew;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}