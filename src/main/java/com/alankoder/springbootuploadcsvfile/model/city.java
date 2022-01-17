package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class city extends areaCounty {

    @Column(name = "city_name")
    private String city_name;

    @Column(name = "density")
    private Integer density;

    public city() {

    }

}
