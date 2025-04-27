package com.example.HeThongDatSanPickleball.service;

import com.example.HeThongDatSanPickleball.entity.Court;
import com.example.HeThongDatSanPickleball.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtService {

    @Autowired
    private CourtRepository courtRepository;

    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }
//    // Lưu hoặc cập nhật sân
//    public void saveCourt(Court court) {
//        courtRepository.save(court);
//    }
//
//    // Xóa sân theo ID
//    public void deleteCourt(Long id) {
//        courtRepository.deleteById(id);
//    }
//
//    // Tìm sân theo ID (để hiển thị form sửa)
//    public Court getCourtById(Long id) {
//        return courtRepository.findById(id).orElse(null);
//    }
}
