package com.ds.ads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @NotNull
    @ManyToOne
    private City city;
    
    @NotNull
    private String District;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the city
     */
    public City getCity() {
        return city;
    }
    /**
     * @param city the city to set
     */
    public void setCity(City city) {
        this.city = city;
    }
    /**
     * @return the district
     */
    public String getDistrict() {
        return District;
    }
    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        District = district;
    }
    
    
}
