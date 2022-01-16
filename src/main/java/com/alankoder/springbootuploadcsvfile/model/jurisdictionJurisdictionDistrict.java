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
@Table(name = "jurisdictionJurisdictionDistrict")
public class jurisdictionJurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courtCircuitNumber", referencedColumnName = "courtCircuitNumber")
    private courtCourt courtCourt;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public jurisdictionJurisdictionDistrict(long id, String jurisdictionDistrictName, String chiefJudge,
            Double distance) {
        this.id = id;
        this.jurisdictionDistrictName = jurisdictionDistrictName;
        this.chiefJudge = chiefJudge;
        this.distance = distance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public courtCourt getCourtCourt() {
        return courtCourt;
    }

    public void setCourtCourt(courtCourt courtCourt) {
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

    public String getChiefJudge() {
        return chiefJudge;
    }

    public void setChiefJudge(String chiefJudge) {
        this.chiefJudge = chiefJudge;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

}
