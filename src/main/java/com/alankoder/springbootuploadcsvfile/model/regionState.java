package com.alankoder.springbootuploadcsvfile.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class regionState extends areaCounty {

    @Column(name = "growth")
    private Double growth;

    @Column(name = "state_id")
    private String state_id;

/*     @OneToMany(mappedBy = "regionState", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<areaCounty> listCountyByStateId = new ArrayList<>();
 */

    public regionState() {

    }



    public regionState(long id, /* List<jurisdictionJurisdictionDistrict> listJurisdictionDistrictByStateId,
            regionState regionState, */ String name, Integer population, Double growth, String state_id) {
        super(id, /* listJurisdictionDistrictByStateId, regionState, */ name, population);
        this.growth = growth;
        this.state_id = state_id;
    }


    public regionState(Double growth, String state_id){
        this.growth = growth;
        this.state_id = state_id;
    }

    public Double getGrowth() {
        return growth;
    }

    public void setGrowth(Double growth) {
        this.growth = growth;
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

 /*    public List<areaCounty> getListCountyByStateId() {
        return listCountyByStateId;
    }

    public void setListCountyByStateId(List<areaCounty> listCountyByStateId) {
        this.listCountyByStateId = listCountyByStateId;
    }
 */
    

}
