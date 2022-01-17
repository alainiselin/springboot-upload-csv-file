package com.alankoder.springbootuploadcsvfile.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


//State muss nach dummy counties eingelesen werden sonst foreign key fehler
@Entity
public class regionState extends areaCounty {

    @Column(name = "state_name")
    private String state_name;

    @Column(name = "growth")
    private Double growth;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "state_id")
    private String state_id;

    public regionState() {

    }

    public regionState(String state_name, String state_id, Double growth) {
        this.state_name = state_name;
        this.growth = growth;
        this.state_id = state_id;
    }

}
