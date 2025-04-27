package com.example.HeThongDatSanPickleball.repository;

import com.example.HeThongDatSanPickleball.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
