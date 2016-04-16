package com.ds.ads.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="city_seq")
    @SequenceGenerator(name="city_seq",sequenceName="city_seq")
    private Long id;
    
    @NotNull
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Region region;
    
    @NotNull
    private String name;
}
