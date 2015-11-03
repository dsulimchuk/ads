package com.ds.ads.model;

import javax.persistence.*;

@Entity
@Table(indexes=@Index(columnList="country", unique=false), name="regions")
public class Region {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="region_seq")
    @SequenceGenerator(name="region_seq",sequenceName="region_seq")
    private Long id;
    
    @ManyToOne(cascade=CascadeType.PERSIST, optional=false)
    private Country country;
    
    @Column(nullable=false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof Region))
	    return false;
	Region other = (Region) obj;
	if (country == null) {
	    if (other.country != null)
		return false;
	} else if (!country.equals(other.country))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }



}
