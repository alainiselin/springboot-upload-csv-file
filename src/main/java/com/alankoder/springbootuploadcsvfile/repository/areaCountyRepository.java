package com.alankoder.springbootuploadcsvfile.repository;

import java.util.Optional;

import com.alankoder.springbootuploadcsvfile.model.areaCounty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface areaCountyRepository extends JpaRepository<areaCounty, Long>{
    
    @Query("select count(id) from area_county where region_state_id = ?1 group by region_state_id order by count(id)")
    public Optional<Long> findAreaCounty(long id);
}
