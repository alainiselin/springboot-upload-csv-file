package com.alankoder.springbootuploadcsvfile.controller;

import java.util.List;
import java.util.Optional;

import com.alankoder.springbootuploadcsvfile.repository.cityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alankoder.springbootuploadcsvfile.model.city;

@CrossOrigin
@Controller
public class cityController {

    @Autowired
    private cityRepository cityRepository;

    @GetMapping("/citys")
    public ResponseEntity<List<city>> getCitys() {
        List<city> result = this.cityRepository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<List<city>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<city>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<city> getCityById(@PathVariable("id") long id) {
        Optional<city> result = this.cityRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<city>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<city>(HttpStatus.NOT_FOUND);
        }
    }
}
