package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class courtCourt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "circuitNumber")
    private Integer circuitNumber;

    public courtCourt() {

    }

    public courtCourt(long id, String name, Integer circuitNumber) {
        this.id = id;
        this.name = name;
        this.circuitNumber = circuitNumber;
    }

    
}
