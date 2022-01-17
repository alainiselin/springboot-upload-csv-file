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

//State muss als erstes eingelesen werden -> sonst ID Fehler
@Entity
public class regionState extends areaCounty {


    @Column(name = "state_name")
    private String state_name;

    @Column(name = "growth")
    private Double growth;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private String state_id;

/*     @OneToMany(mappedBy = "regionState", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<areaCounty> listAreaCounty = new ArrayList<areaCounty>(); */

    public regionState() {

    }

/*     public regionState(String state_name, Double growth, String state_id, List<areaCounty> listAreaCounty) {
        this.state_name = state_name;
        this.growth = growth;
        this.state_id = state_id;
        this.listAreaCounty = listAreaCounty;
    } */

    public regionState(String state_name, /* String state_id, */ Double growth) {
        this.state_name = state_name;
        this.growth = growth;
        /* this.state_id = state_id; */
    }

}
