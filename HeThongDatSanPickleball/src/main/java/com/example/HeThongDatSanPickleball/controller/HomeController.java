package com.example.HeThongDatSanPickleball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController
{

    @GetMapping("/index")
    public String indexPage(){
        return "index";
    }
    @GetMapping("/bangGia")
    public String bangGiaPage(){
        return "bangGia";
    }
    @GetMapping("/suKien")
    public String suKienPage(){
        return "suKien";
    }
    @GetMapping("/lienHe")
    public String lienHePage(){
        return "lienHe";
    }
    @GetMapping("/tuVan")
    public String tuVanPage(){
        return "tuVan";
    }
    @GetMapping("/Admin/ThongTinDatSan")
    public String ThongTinDatSanPage()
    {
        return "Admin/ThongTinDatSan";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
