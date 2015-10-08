package com.ds.ads.model;

import java.io.IOException;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

@Entity
@XmlRootElement
public class User implements JsonSerializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    private long id;
    
    @NotNull
    private String login;
    
    @NotNull
    private String pass;
    
    @NotNull
    private String name;
    
    @ManyToOne(cascade=CascadeType.ALL)
    
    private Location location;
 
    @ElementCollection(fetch=FetchType.EAGER)
    @JoinTable(name="user_phones", joinColumns=@JoinColumn(name="user_id"))
    @GenericGenerator(name="gen1", strategy="hilo")
    @CollectionId(columns = { @Column(name="user_phones_id") }, generator = "gen1", type = @Type(type="long") )
    private List<Phone> phones = new ArrayList<>();
    

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


    @Override
    public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
	jgen.writeStartObject();
	jgen.writeNumberField("id", id);
	jgen.writeStringField("login", login);
	jgen.writeStringField("name", name);
	jgen.writeStringField("pass", pass);
	jgen.writeStringField("location_id", (location==null)?"null":String.valueOf(location.getId()));
	
	jgen.writeEndObject();
	
    }


    @Override
    public void serializeWithType(JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
	    throws IOException, JsonProcessingException {
	// TODO Auto-generated method stub
	
    }
}
