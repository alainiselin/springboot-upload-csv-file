package com.alankoder.springbootuploadcsvfile.service;

import java.io.IOException;
import java.util.List;

import com.alankoder.springbootuploadcsvfile.model.city;
import com.alankoder.springbootuploadcsvfile.helper.cityCSVHelper;
import com.alankoder.springbootuploadcsvfile.repository.cityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class cityCSVService {
    @Autowired
    cityRepository cityRepository;

    public void save(MultipartFile file) {
        System.out.println("until before try");
        try {
            System.out.println("inside courtCSVService try");
            List<city> listCity = cityCSVHelper.csvToCity(file.getInputStream());
            System.out.println("csv to Court success");
            cityRepository.saveAll(listCity);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<city> getAllCitys() {
        return cityRepository.findAll();
    }
}