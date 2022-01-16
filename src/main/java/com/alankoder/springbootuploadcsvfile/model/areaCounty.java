package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "areaCounty")
@Inheritance(strategy = InheritanceType.JOINED)
public class areaCounty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "areaCounty", // points to field that owns the relationship, it's jurisdiction because in the
                                        // jurisdiction entity the area is referenced
            cascade = CascadeType.ALL, // each operation performed on the area entity will be propagated to the entitys
                                       // of the list
            orphanRemoval = true // if we remove the area entity also the entitys stored in the list will be
                                 // removed
    )
    private List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByStateId = new ArrayList<jurisdictionJurisdictionDistrict>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private regionState regionState;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private Integer population;

    public areaCounty() {

    }

    public areaCounty(long id, List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByStateId,
            com.alankoder.springbootuploadcsvfile.model.regionState regionState, String name, Integer population) {
        this.id = id;
        this.listJurisdictionDistrictByStateId = listJurisdictionDistrictByStateId;
        this.regionState = regionState;
        this.name = name;
        this.population = population;
    }

    public areaCounty(long id, String name, Integer population){
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<jurisdictionJurisdictionDistrict> getListJurisdictionDistrictByStateId() {
        return listJurisdictionDistrictByStateId;
    }

    public void setListJurisdictionDistrictByStateId(
            List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByStateId) {
        this.listJurisdictionDistrictByStateId = listJurisdictionDistrictByStateId;
    }

    public regionState getRegionState() {
        return regionState;
    }

    public void setRegionState(regionState regionState) {
        this.regionState = regionState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    



}
