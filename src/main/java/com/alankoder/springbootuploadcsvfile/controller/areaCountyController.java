package com.alankoder.springbootuploadcsvfile.controller;

import java.util.List;
import java.util.Optional;

import com.alankoder.springbootuploadcsvfile.repository.areaCountyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.alankoder.springbootuploadcsvfile.model.areaCounty;

@CrossOrigin
@Controller
public class areaCountyController {

    @Autowired
    private areaCountyRepository areaCountyRepository;

    @GetMapping("/areaCountys")
    public ResponseEntity<List<areaCounty>> getAreaCountys() {
        List<areaCounty> result = this.areaCountyRepository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<List<areaCounty>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<areaCounty>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/areaCounty/{id}")
    public ResponseEntity<areaCounty> getAreaCountyById(@PathVariable("id") long id) {
        Optional<areaCounty> result = this.areaCountyRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<areaCounty>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<areaCounty>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/areaCounty/wp4/{id}")
	public ResponseEntity<Long> findareaCounty(@PathVariable("id") long id) {
		Optional<Long> result = this.areaCountyRepository.findAreaCounty(id);
		
		if(result.isPresent()) {
			return new ResponseEntity<Long>(result.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
	}
	
}
