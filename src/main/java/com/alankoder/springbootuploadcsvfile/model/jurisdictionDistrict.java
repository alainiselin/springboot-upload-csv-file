package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jurisdictionDistrict")
public class jurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courtCircuitNumber", referencedColumnName = "courtCircuitNumber")
    private court courtCourt;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private areaCounty areaCounty;

    @Column(name = "jurisdictionDistrictName")
    private String jurisdictionDistrictName;

    @Column(name = "chiefJudge")
    private String chiefJudge;

    @Column(name = "distance")
    private Double distance;

    public jurisdictionDistrict() {

    }

    public jurisdictionDistrict(long id, com.alankoder.springbootuploadcsvfile.model.court courtCourt,
            com.alankoder.springbootuploadcsvfile.model.areaCounty areaCounty, String jurisdictionDistrictName,
            String chiefJudge, Double distance) {
        this.id = id;
        this.courtCourt = courtCourt;
        this.areaCounty = areaCounty;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.chiefJudge = chiefJudge;
        this.distance = distance;
    }

    public jurisdictionDistrict(long id, String jurisdictionDistrictName, String chiefJudge,
            Double distance) {
        this.id = id;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.chiefJudge = chiefJudge;
        this.distance = distance;
    }

}
