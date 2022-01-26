package com.alankoder.springbootuploadcsvfile.repository;

import com.alankoder.springbootuploadcsvfile.model.jurisdictionDistrict;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface jurisdictionDistrictRepository extends JpaRepository<jurisdictionDistrict, Long> {

    @Query("select c.name from court c, jurisdiction_district j where c.id = j.court and j.distance =?1")
    public List<String> findAllCourts(double distance);
}
