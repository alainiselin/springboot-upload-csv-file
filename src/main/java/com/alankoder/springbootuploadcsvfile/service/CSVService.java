package com.alankoder.springbootuploadcsvfile.service;

import java.io.IOException;
import java.util.List;

import com.alankoder.springbootuploadcsvfile.model.Tutorial;
import com.alankoder.springbootuploadcsvfile.helper.CSVHelper;
import com.alankoder.springbootuploadcsvfile.repository.TutorialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CSVService {
  @Autowired
  TutorialRepository toturialRepository;

  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      toturialRepository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public List<Tutorial> getAllTutorials() {
    return toturialRepository.findAll();
  }
}
