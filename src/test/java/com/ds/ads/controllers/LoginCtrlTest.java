package com.ds.ads.controllers;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ds.ads.AdsApplication;
import com.ds.ads.services.UserRepository;
import com.jayway.restassured.RestAssured;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=AdsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class LoginCtrlTest {

    @Value("${local.server.port}")
    int port;
    
    @Autowired
    UserRepository userRep;
    
    @Before
    public void setUp(){
	RestAssured.port = port;
	userRep.deleteAll();
    }
    
    @Test
    public void testRegisterFirst() {
	Map<String, String> req  = new HashMap<>();
	req.put("login", "vasya123");
	req.put("pass", "sobaka");
	req.put("name", "valua");
	assertThat("userRep is empty", userRep.count(), equalTo(0L));
	
	given().parameters(req).
	when().post("/api/login/register").
	then().statusCode(HttpStatus.SC_OK);
	
	assertThat("userRep count now 1", userRep.count(), equalTo(1L));
    }
    
    @Test
    public void testRegisterExeption() {
	Map<String, String> req  = new HashMap<>();
	req.put("login", "vasya123");
	req.put("pass", "sobaka");
	req.put("name", "valua");
	
	assertThat("userRep is empty", userRep.count(), equalTo(0L));
	
	given().parameters(req).
	when().post("/api/login/register").
		then().assertThat().statusCode(HttpStatus.SC_OK);

	given().parameters(req).
	when().post("/api/login/register").
		then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
	assertThat("userRep count now 1", userRep.count(), equalTo(1L));
    }

}
