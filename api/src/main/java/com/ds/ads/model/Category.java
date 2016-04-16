package com.ds.ads.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne
    private Category parentCategory;
}
