package com.alankoder.springbootuploadcsvfile.service;

import java.io.IOException;
import java.util.List;

import com.alankoder.springbootuploadcsvfile.model.court;
import com.alankoder.springbootuploadcsvfile.helper.courtCSVHelper;
import com.alankoder.springbootuploadcsvfile.repository.courtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class courtCSVService {
    @Autowired
    courtRepository courtRepository;

    public void save(MultipartFile file) {
        System.out.println("until before try");
        try {
            System.out.println("inside courtCSVService try");
            List<court> listCourts = courtCSVHelper.csvToCourt(file.getInputStream());
            System.out.println("csv to Court success");
            courtRepository.saveAll(listCourts);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<court> getAllCourts() {
        return courtRepository.findAll();
    }
}