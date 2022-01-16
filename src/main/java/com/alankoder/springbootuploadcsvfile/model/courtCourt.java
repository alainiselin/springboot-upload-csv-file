package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courtCourt")
public class courtCourt {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /* @OneToMany(mappedBy = "courtCourt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByCourtCircuitNumber = new ArrayList<jurisdictionJurisdictionDistrict>(); */

    @Column(name = "name")
    private String name;

    @Column(name = "courtCircuitNumber")
    private Integer courtCircuitNumber;

    public courtCourt() {

    }

/*     public courtCourt(long id, List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByCourtCircuitNumber,
            String name, Integer courtCircuitNumber) {
        this.id = id;
        this.listJurisdictionDistrictByCourtCircuitNumber = listJurisdictionDistrictByCourtCircuitNumber;
        this.name = name;
        this.courtCircuitNumber = courtCircuitNumber;
    } */

    public courtCourt(long id, String name, Integer courtCircuitNumber) {
        this.id = id;
        this.name = name;
        this.courtCircuitNumber = courtCircuitNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /* public List<jurisdictionJurisdictionDistrict> getListJurisdictionDistrictByCourtCircuitNumber() {
        return listJurisdictionDistrictByCourtCircuitNumber;
    }

    public void setListJurisdictionDistrictByCourtCircuitNumber(
            List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByCourtCircuitNumber) {
        this.listJurisdictionDistrictByCourtCircuitNumber = listJurisdictionDistrictByCourtCircuitNumber;
    } */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourtCircuitNumber() {
        return courtCircuitNumber;
    }

    public void setCourtCircuitNumber(Integer courtCircuitNumber) {
        this.courtCircuitNumber = courtCircuitNumber;
    }

}
