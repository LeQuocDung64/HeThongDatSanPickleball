package com.example.HeThongDatSanPickleball.service;

import com.example.HeThongDatSanPickleball.entity.User;
import com.example.HeThongDatSanPickleball.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
