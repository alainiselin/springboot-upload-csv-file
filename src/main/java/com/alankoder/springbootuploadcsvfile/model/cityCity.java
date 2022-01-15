package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class cityCity extends areaCounty {

    @Column(name = "density")
    private Integer density;

    public cityCity() {

    }

    public cityCity(long id, String state_id, String name, Integer population, Integer density) {
        super(id, state_id, name, population);
        this.density = density;
    }

}
