package com.alankoder.springbootuploadcsvfile.service;

import java.io.IOException;
import java.util.List;

import com.alankoder.springbootuploadcsvfile.model.regionState;
import com.alankoder.springbootuploadcsvfile.helper.regionCSVHelper;
import com.alankoder.springbootuploadcsvfile.repository.regionStateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class regionCSVService {
    @Autowired
    regionStateRepository regionRepository;

    public void save(MultipartFile file) {
        System.out.println("until before try");
        try {
            System.out.println("inside regionCSVService try");
            List<regionState> listStates = regionCSVHelper.csvToRegion(file.getInputStream());
            System.out.println("csv to Region success");
            regionRepository.saveAll(listStates);
            System.out.println("regionRepository.safeAll success");
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<regionState> getAllRegions() {
        return regionRepository.findAll();
    }
}