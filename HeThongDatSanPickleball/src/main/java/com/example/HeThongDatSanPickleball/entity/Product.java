package com.example.HeThongDatSanPickleball.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    private Integer id;

    private String name;
    private Integer price;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String image;

    @Column(name = "is_new")
    private Boolean isNew;

    public enum Category {
        food, equipment
    }

    // Constructor không tham số (bắt buộc cho JPA)
    public Product() {
    }
    // Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
}
