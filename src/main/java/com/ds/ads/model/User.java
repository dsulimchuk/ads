package com.ds.ads.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@XmlRootElement
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long id;
    
    @NotNull
    private String login;
    
    @NotNull
    private String pass;
    
    @NotNull
    private String name;
    
    @ManyToOne
    private Location location;
 
    @OneToMany(mappedBy="user")
    @XmlTransient
    private List<Phone> phones;
    
    public void addPhone(Phone phone) {
	if (this.phones == null) {
	    this.phones = new ArrayList<>();
	}
	phones.add(phone);
    }
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }
    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
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
     * @return the location
     */
    public Location getLocation() {
        return location;
    }
    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }
    /**
     * @return the phones
     */
    public List<Phone> getPhones() {
        return phones;
    }
    /**
     * @param phones the phones to set
     */
    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User [id=" + id + ", login=" + login + ", pass=" + pass + ", name=" + name + ", location=" + location
		+ ", phones=" + phones + "]";
    }
}
