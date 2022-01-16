package com.alankoder.springbootuploadcsvfile.service;

import java.io.IOException;
import java.util.List;

import com.alankoder.springbootuploadcsvfile.model.courtCourt;
import com.alankoder.springbootuploadcsvfile.helper.courtCSVHelper;
import com.alankoder.springbootuploadcsvfile.repository.courtCourtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class courtCSVService {
    @Autowired
    courtCourtRepository courtRepository;

    public void save(MultipartFile file) {
        try {
            List<courtCourt> listCourts = courtCSVHelper.csvToCourt(file.getInputStream());
            courtRepository.saveAll(listCourts);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<courtCourt> getAllCourts() {
        return courtRepository.findAll();
    }
}