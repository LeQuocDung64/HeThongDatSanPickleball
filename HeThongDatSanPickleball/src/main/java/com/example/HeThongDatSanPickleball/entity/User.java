package com.example.HeThongDatSanPickleball.entity;

import com.example.HeThongDatSanPickleball.Enum.Role;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String email;
    private String phone;
    private String address;

    // ===================
    @Enumerated(EnumType.STRING)
    private Role role;
    // ===================
    // Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email; }
    public void setEmail(String email) {
        this.email = email; }

    public String getPhone() {
        return phone; }
    public void setPhone(String phone) {
        this.phone = phone; }

    public String getAddress() {
        return address; }
    public void setAddress(String address) {
        this.address = address; }
}
