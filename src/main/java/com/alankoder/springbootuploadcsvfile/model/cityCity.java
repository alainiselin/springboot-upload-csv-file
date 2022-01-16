package com.alankoder.springbootuploadcsvfile.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class cityCity extends areaCounty {

    @Column(name = "density")
    private Integer density;

    public cityCity() {

    }

    public cityCity(long id, List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByStateId,
            com.alankoder.springbootuploadcsvfile.model.regionState regionState, String name, Integer population,
            Integer density) {
        super(id, listJurisdictionDistrictByStateId, regionState, name, population);
        this.density = density;
    }

}
