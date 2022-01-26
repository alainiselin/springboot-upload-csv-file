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
    private areaCounty areaCounty;

    @Column(name = "jurisdictionDistrictName")
    private String jurisdictionDistrictName;

    /*
     * @Column(name = "chiefJudge")
     * private String chiefJudge;
     */

    @Column(name = "distance")
    private Double distance;

    public jurisdictionDistrict() {

    }

    public jurisdictionDistrict(long id, court courtCourt,
            com.alankoder.springbootuploadcsvfile.model.areaCounty areaCounty, String jurisdictionDistrictName,
            Double distance) {
        this.id = id;
        this.courtCourt = courtCourt;
        this.areaCounty = areaCounty;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public court getCourtCourt() {
        return courtCourt;
    }

    public void setCourtCourt(court courtCourt) {
        this.courtCourt = courtCourt;
    }

    public areaCounty getAreaCounty() {
        return areaCounty;
    }

    public void setAreaCounty(areaCounty areaCounty) {
        this.areaCounty = areaCounty;
    }

    public String getJurisdictionDistrictName() {
        return jurisdictionDistrictName;
    }

    public void setJurisdictionDistrictName(String jurisdictionDistrictName) {
        this.jurisdictionDistrictName = jurisdictionDistrictName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

}
