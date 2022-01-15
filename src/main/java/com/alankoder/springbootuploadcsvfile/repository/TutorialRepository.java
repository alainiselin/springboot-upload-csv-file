package com.alankoder.springbootuploadcsvfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alankoder.springbootuploadcsvfile.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
}