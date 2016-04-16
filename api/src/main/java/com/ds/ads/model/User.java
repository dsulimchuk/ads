package com.ds.ads.model;

import java.util.HashSet;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String pass;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location location;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "user_phones", joinColumns = @JoinColumn(name = "user_id"))
//    @SequenceGenerator(name="user_phones_seq", sequenceName="user_phones_seq")
//    @CollectionId(columns = { @Column(name="user_phones_id") }, generator = "user_phones_seq", type = @Type(type="long") )
    private final Set<Phone> phones = new HashSet<>();

    @JsonSetter("login")
    public void setLoginLower(String login) {
        this.login = login.toLowerCase();
    }

}
