package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class courtCourt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "circuitCourtNumber")
    private List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByCourtCircuitNumber = new ArrayList<jurisdictionJurisdictionDistrict>();

    @Column(name = "name")
    private String name;

    @Column(name = "courtCircuitNumber")
    private Integer courtCircuitNumber;

    public courtCourt() {

    }

    public courtCourt(long id, String name, Integer courtCircuitNumber) {
        this.id = id;
        this.name = name;
        this.courtCircuitNumber = courtCircuitNumber;
    }

}
