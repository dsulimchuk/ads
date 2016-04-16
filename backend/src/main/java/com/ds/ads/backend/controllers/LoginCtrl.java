package com.ds.ads.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.ads.model.User;
import com.ds.ads.backend.services.UserRepository;

@RestController()
@RequestMapping("/api/login")
@EnableAutoConfiguration
public class LoginCtrl {

    @Autowired
    private UserRepository userRep;

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Iterable<User> getAllUsers() {
	Iterable<User> result = userRep.findAll();
	return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User userFromQuery) {
	if ( userRep.findByLogin(userFromQuery.getLogin()) != null ) {
	    return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}
	
	userFromQuery = userRep.save(userFromQuery);
	
	return new ResponseEntity<User>(userFromQuery, HttpStatus.CREATED);
    }
}
