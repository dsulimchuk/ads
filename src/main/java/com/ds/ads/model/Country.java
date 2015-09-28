package com.ds.ads.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
    @Column(unique=true)
    private String name;
    

    @Column(unique=true)
    private String code;

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
    
    public String getCode() {
	return code;
    }
    
    public void setCode(String code) {
	this.code = code;
    }
    
}
