package com.ds.ads.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    private Long id;
    
    @Column(unique=true, nullable=false)
    private String login;
    
    @Column(nullable=false)
    private String pass;
    
    @Column(nullable=false)
    private String name;
    
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Location location;
 
    @ElementCollection(fetch=FetchType.EAGER)
    @JoinTable(name="user_phones", joinColumns=@JoinColumn(name="user_id"))
    @SequenceGenerator(name="user_phones_seq", sequenceName="user_phones_seq")
    @CollectionId(columns = { @Column(name="user_phones_id") }, generator = "user_phones_seq", type = @Type(type="long") )
    private List<Phone> phones = new ArrayList<>();
   
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login.toLowerCase();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((login == null) ? 0 : login.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((pass == null) ? 0 : pass.hashCode());
	result = prime * result + ((phones == null) ? 0 : phones.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (!(obj instanceof User))
	    return false;
	User other = (User) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (location == null) {
	    if (other.location != null)
		return false;
	} else if (!location.equals(other.location))
	    return false;
	if (login == null) {
	    if (other.login != null)
		return false;
	} else if (!login.equals(other.login))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (pass == null) {
	    if (other.pass != null)
		return false;
	} else if (!pass.equals(other.pass))
	    return false;
	if (phones == null) {
	    if (other.phones != null)
		return false;
	} else if (!phones.equals(other.phones))
	    return false;
	return true;
    }
}
