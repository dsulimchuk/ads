package com.ds.ads.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(indexes = @Index(columnList = "country", unique = false), name = "regions")
@Data
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "region_seq")
    @SequenceGenerator(name = "region_seq", sequenceName = "region_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Country country;

    @Column(nullable = false)
    private String name;

}