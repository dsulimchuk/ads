package com.ds.ads.model;

import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
 
    @ElementCollection(fetch=FetchType.EAGER)
    @JoinTable(name="user_phones", joinColumns=@JoinColumn(name="user_id"))
    @GenericGenerator(name="gen1", strategy="hilo")
    @CollectionId(columns = { @Column(name="user_phones_id") }, generator = "gen1", type = @Type(type="long") )
    private List<Phone> phones = new ArrayList<>();
    

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "User [id=" + id + ", login=" + login + ", pass=" + pass + ", name=" + name + ", location=" + location
		+ ", phones=" + phones + "]";
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
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
}
