package com.ds.ads.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(indexes=@Index(columnList="code", unique=true))
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
    @Column(nullable=false)
    private String name;
    
    @Column(nullable=false)
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
    
    @JsonSetter("code")
    public void setCode(String code) {
	this.code = code.toLowerCase();
    }
    
}
