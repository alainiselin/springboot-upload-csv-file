package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jurisdictionJurisdictionDistrict")
public class jurisdictionJurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "courtCircuitNumber", referencedColumnName = "courtCircuitNumber")
    private courtCourt courtCourt;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private areaCounty areaCounty;

    @Column(name = "jurisdictionDistrictName")
    private String jurisdictionDistrictName;

    @Column(name = "chiefJudge")
    private String chiefJudge;

    @Column(name = "distance")
    private Double distance;

    public jurisdictionJurisdictionDistrict() {

    }

    public jurisdictionJurisdictionDistrict(long id, com.alankoder.springbootuploadcsvfile.model.courtCourt courtCourt,
            com.alankoder.springbootuploadcsvfile.model.areaCounty areaCounty, String jurisdictionDistrictName,
            String chiefJudge, Double distance) {
        this.id = id;
        this.courtCourt = courtCourt;
        this.areaCounty = areaCounty;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.chiefJudge = chiefJudge;
        this.distance = distance;
    }

}
