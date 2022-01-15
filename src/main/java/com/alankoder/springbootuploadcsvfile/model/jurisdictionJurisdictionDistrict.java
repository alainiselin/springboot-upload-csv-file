package com.alankoder.springbootuploadcsvfile.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class jurisdictionJurisdictionDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "courtCircuitNumber")
    private List<courtCourt> listCourtByCourtCircuitNumber;

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

}
