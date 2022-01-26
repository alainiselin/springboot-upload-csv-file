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

    public city(String city_name, Integer density) {
        this.city_name = city_name;
        this.density = density;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }

}
