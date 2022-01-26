package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jurisdictionDistrict")
public class jurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private court court;

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

    public jurisdictionDistrict(long id, court court,
            com.alankoder.springbootuploadcsvfile.model.areaCounty areaCounty, String jurisdictionDistrictName,
            Double distance) {
        this.id = id;
        this.court = court;
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

    public court getCourt() {
        return court;
    }

    public void setCourt(court court) {
        this.court = court;
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
