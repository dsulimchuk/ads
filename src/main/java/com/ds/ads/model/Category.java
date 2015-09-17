package com.ds.ads.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private long id;
	private String name;
	
	@OneToOne
	private Category parentCategory;
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
	 * @return the name
	 */
	public String getName() {
	    return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
	    this.name = name;
	}
	/**
	 * @return the parentCategory
	 */
	public Category getParentCategory() {
	    return parentCategory;
	}
	/**
	 * @param parentCategory the parentCategory to set
	 */
	public void setParentCategory(Category parentCategory) {
	    this.parentCategory = parentCategory;
	}

	
}
