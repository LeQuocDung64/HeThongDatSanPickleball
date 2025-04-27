package com.example.HeThongDatSanPickleball.controller;

import com.example.HeThongDatSanPickleball.entity.Court;
import com.example.HeThongDatSanPickleball.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CourtController {

    @Autowired
    private CourtService courtService;

    @GetMapping("/datSan")
    public String getAllCourts(Model model) {
        List<Court> courts = courtService.getAllCourts();
        model.addAttribute("courts", courts);
        return "datSan";
    }
    @GetMapping("/admin/Chinhsua")
    public String getCourtsForAdmin(Model model) {
        List<Court> courts = courtService.getAllCourts();
        model.addAttribute("courts", courts);
        return "Admin/ChinhSua";
    }

//    // Hiển thị form thêm sân
//    @GetMapping("/courts/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("court", new Court());
//        return "Admin/add"; // tạo file add.html như hướng dẫn trước
//    }
//
//    // Lưu sân mới hoặc cập nhật sân cũ
//    @PostMapping("/courts/save")
//    public String saveCourt(@ModelAttribute Court court) {
//        courtService.saveCourt(court);
//        return "redirect:/admin/chinhsua";
//    }
//
//    // Xóa sân
//    @GetMapping("/courts/delete/{id}")
//    public String deleteCourt(@PathVariable Long id) {
//        courtService.deleteCourt(id);
//        return "redirect:/admin/chinhsua";
//    }
//
//    // Hiển thị form chỉnh sửa sân
//    @GetMapping("/courts/edit/{id}")
//    public String showEditForm(@PathVariable Long id, Model model) {
//        Court court = courtService.getCourtById(id);
//        model.addAttribute("court", court);
//        return "Admin/edit"; // tạo file edit.html giống add.html nhưng có dữ liệu sẵn
//    }
}

