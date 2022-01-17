package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.AttributeAccessor;

@Entity
@Table(name = "areaCounty")
@Inheritance(strategy = InheritanceType.JOINED)
public class areaCounty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "areaCounty", // points to field that owns the relationship, it's jurisdiction because in the
                                        // jurisdiction entity the area is referenced
            cascade = CascadeType.ALL, // each operation performed on the area entity will be propagated to the entitys
                                       // of the list
            orphanRemoval = true // if we remove the area entity also the entitys stored in the list will be
                                 // removed
    )
    private List<jurisdictionDistrict> listJurisdictionDistrictByStateId = new ArrayList<jurisdictionDistrict>();

    // benötigt Fremdschlüssel state_id
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private regionState regionState;

    @Column(name = "county_name")
    private String county_name;

    @Column(name = "population")
    private Integer population;

    public areaCounty() {

    }

}
