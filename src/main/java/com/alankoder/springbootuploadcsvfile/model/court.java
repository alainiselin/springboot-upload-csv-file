package com.alankoder.springbootuploadcsvfile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "court")
public class court {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "courtCircuitNumber")
    private Integer courtCircuitNumber;

    public court() {

    }

    public court(long id, String name, Integer courtCircuitNumber) {
        this.id = id;
        this.name = name;
        this.courtCircuitNumber = courtCircuitNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCourtCircuitNumber() {
        return courtCircuitNumber;
    }

    public void setCourtCircuitNumber(Integer courtCircuitNumber) {
        this.courtCircuitNumber = courtCircuitNumber;
    }

}
