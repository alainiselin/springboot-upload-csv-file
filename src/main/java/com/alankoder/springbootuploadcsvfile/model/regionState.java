package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class regionState extends areaCounty {

    @Column(name = "growth")
    private Integer growth;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "state_id")
    private List<areaCounty> listCountyByStateId = new ArrayList<>();

    public regionState() {

    }

    public regionState(long id, String state_id, String name, Integer population, Integer growth,
            List<areaCounty> listCountyByStateId) {
        super(id, state_id, name, population);
        this.growth = growth;
        this.listCountyByStateId = listCountyByStateId;
    }

}
