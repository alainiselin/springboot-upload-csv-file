package com.alankoder.springbootuploadcsvfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

import com.alankoder.springbootuploadcsvfile.helper.courtCSVHelper;
import com.alankoder.springbootuploadcsvfile.message.ResponseMessage;
import com.alankoder.springbootuploadcsvfile.service.courtCSVService;
import com.alankoder.springbootuploadcsvfile.model.court;
import com.alankoder.springbootuploadcsvfile.repository.courtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@Controller
public class courtController {

    @Autowired
    courtCSVService fileService;

    @Autowired
    private courtRepository courtRepository;

    @PostMapping("/uploadCourtFile")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (courtCSVHelper.hasCSVFormat(file)) {
            try {
                fileService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }

        message = "Please upload a csv file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

    /*
     * @GetMapping("/courts")
     * public ResponseEntity<List<court>> getAllCourts() {
     * try {
     * List<court> listCourts = fileService.getAllCourts();
     * 
     * if (listCourts.isEmpty()) {
     * return new ResponseEntity<>(HttpStatus.NO_court);
     * }
     * 
     * return new ResponseEntity<>(listCourts, HttpStatus.OK);
     * } catch (Exception e) {
     * return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    @GetMapping("/courts")
    public ResponseEntity<List<court>> getCourts() {
        List<court> result = this.courtRepository.findAll();

        if (!result.isEmpty()) {
            return new ResponseEntity<List<court>>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<court>>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/court/{id}")
    public ResponseEntity<court> getcourtById(@PathVariable("id") long id) {
        Optional<court> result = this.courtRepository.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity<court>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<court>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * @GetMapping("/court/wp4/{id}")
     * public ResponseEntity<Long> findcourt(@PathVariable("id") long id) {
     * Optional<Long> result = this.courtRepository.findCourt(id);
     * 
     * if(result.isPresent()) {
     * return new ResponseEntity<Long>(result.get(), HttpStatus.OK);
     * } else {
     * return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
     * }
     * }
     */

}
