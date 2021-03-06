package com.alankoder.springbootuploadcsvfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class SpringBootUploadCsvFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUploadCsvFileApplication.class, args);
	}

}
