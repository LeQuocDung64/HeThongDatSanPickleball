package com.example.HeThongDatSanPickleball.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // Lấy danh sách quyền của người dùng
        Collection<?> authorities = authentication.getAuthorities();
        String redirectURL = "/index";
        // xác định URL chuyển hướng
        for (var authority : authorities) {
            String role = authority.toString();
            if ("ADMIN".equals(role)) {
                redirectURL = "/admin";
                break;
            } else if ("USER".equals(role)) {
                redirectURL = "/index";
                break;
            }
        }
        response.sendRedirect(redirectURL);
    }
}
