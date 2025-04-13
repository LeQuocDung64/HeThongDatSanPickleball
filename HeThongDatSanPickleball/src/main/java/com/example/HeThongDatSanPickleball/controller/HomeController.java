package com.example.HeThongDatSanPickleball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/hi")
    public String hiPage(){
        return "hi";
    }

}
