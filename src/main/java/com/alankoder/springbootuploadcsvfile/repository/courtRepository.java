package com.alankoder.springbootuploadcsvfile.repository;

import com.alankoder.springbootuploadcsvfile.model.court;

import org.springframework.data.jpa.repository.JpaRepository;

public interface courtRepository extends JpaRepository<court, Long> {
    
}
