package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "areaCounty")
@Inheritance(strategy = InheritanceType.JOINED)
public class areaCounty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // benötigt Fremdschlüssel state_id
    @ManyToOne
    private regionState regionState;

    @Column(name = "county_name")
    private String county_name;

    @Column(name = "population")
    private Integer population;

    public areaCounty() {

    }

    public areaCounty(long id, com.alankoder.springbootuploadcsvfile.model.regionState regionState, String county_name,
            Integer population) {
        this.id = id;
        this.regionState = regionState;
        this.county_name = county_name;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public regionState getRegionState() {
        return regionState;
    }

    public void setRegionState(regionState regionState) {
        this.regionState = regionState;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

}
