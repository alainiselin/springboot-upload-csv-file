package com.alankoder.springbootuploadcsvfile.repository;

import com.alankoder.springbootuploadcsvfile.model.courtCourt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface courtCourtRepository extends JpaRepository<courtCourt, Long> {
    
}
