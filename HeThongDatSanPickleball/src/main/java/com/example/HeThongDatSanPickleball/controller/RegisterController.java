package com.example.HeThongDatSanPickleball.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@Controller
public class RegisterController {

    private final PasswordEncoder passwordEncoder;

    // Giả lập database bằng Map (có thể thay bằng repository nếu bạn có DB)
    private final ConcurrentHashMap<String, String> fakeUserDb = new ConcurrentHashMap<>();

    @Autowired
    public RegisterController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String confirmPassword,
                               Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Mật khẩu không khớp.");
            return "register";
        }

        if (fakeUserDb.containsKey(username)) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại.");
            return "register";
        }

        fakeUserDb.put(username, passwordEncoder.encode(password));
        model.addAttribute("success", "Đăng ký thành công! Bạn có thể đăng nhập.");
        return "register";
    }
}
