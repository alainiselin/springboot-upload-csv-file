package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class jurisdictionJurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courtCircuitNumber")
    private courtCourt courtCourt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id")
    private areaCounty areaCounty;

    @Column(name = "jurisdictionDistrictName")
    private String jurisdictionDistrictName;

    @Column(name = "courtCircuitNumber")
    private Integer courtCircuitNumber;

    @Column(name = "state_id")
    private String state_id;

    @Column(name = "chiefJudge")
    private String chiefJudge;

    @Column(name = "distance")
    private Double distance;

    public jurisdictionJurisdictionDistrict() {

    }

    public jurisdictionJurisdictionDistrict(long id, com.alankoder.springbootuploadcsvfile.model.courtCourt courtCourt,
            com.alankoder.springbootuploadcsvfile.model.areaCounty areaCounty, String jurisdictionDistrictName,
            Integer courtCircuitNumber, String state_id, String chiefJudge, Double distance) {
        this.id = id;
        this.courtCourt = courtCourt;
        this.areaCounty = areaCounty;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.courtCircuitNumber = courtCircuitNumber;
        this.state_id = state_id;
        this.chiefJudge = chiefJudge;
        this.distance = distance;
    }

}
