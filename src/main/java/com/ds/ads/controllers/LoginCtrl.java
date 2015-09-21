package com.ds.ads.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ds.ads.model.User;
import com.ds.ads.services.UserRepository;

@RestController()
@RequestMapping("/login")
@EnableAutoConfiguration
public class LoginCtrl {
   
   @Autowired
    private UserRepository userRep;
    
    @RequestMapping(value="/info",method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Iterable<User> getAllUsers() {
	Iterable<User> result = userRep.findAll();
	return result;
    }
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public User register(@RequestParam String login, @RequestParam String pass,
	    @RequestParam String name) {
	User user = new User();
	user.setLogin(login);
	user.setPass(pass);
	user.setName(name);
	
//	userRep.save(user);
	System.out.println(user);
	return user;
	
    }
}
