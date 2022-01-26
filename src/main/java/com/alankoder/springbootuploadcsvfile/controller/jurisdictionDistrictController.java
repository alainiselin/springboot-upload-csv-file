package com.alankoder.springbootuploadcsvfile.controller;

import java.util.List;
import java.util.Optional;

import com.alankoder.springbootuploadcsvfile.repository.jurisdictionDistrictRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alankoder.springbootuploadcsvfile.model.jurisdictionDistrict;

@CrossOrigin
@Controller
public class jurisdictionDistrictController {

    @Autowired
    private jurisdictionDistrictRepository jurisdictionDistrictRepository;

    @GetMapping("/jurisdictionDistricts")
    public ResponseEntity<List<jurisdictionDistrict>> getJurisdictionDistricts() {
        List<jurisdictionDistrict> result = this.jurisdictionDistrictRepository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<List<jurisdictionDistrict>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<jurisdictionDistrict>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/jurisdictionDistrict/{id}")
    public ResponseEntity<jurisdictionDistrict> getJurisdictionDistrictById(@PathVariable("id") long id) {
        Optional<jurisdictionDistrict> result = this.jurisdictionDistrictRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<jurisdictionDistrict>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<jurisdictionDistrict>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/jurisdictionDistrict/wp4/{distance}")
    public ResponseEntity<List<String>> getCourtByDistance(@PathVariable("distance") Double distance) {
        List<String> result = this.jurisdictionDistrictRepository.findAllCourts(distance);

        if (!result.isEmpty()) {
            return new ResponseEntity<List<String>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<String>>(HttpStatus.NOT_FOUND);
        }
    }

}
