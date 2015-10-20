package com.ds.ads.controllers;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import com.ds.ads.AdsApplication;
import com.ds.ads.model.City;
import com.ds.ads.model.Country;
import com.ds.ads.model.Location;
import com.ds.ads.model.Phone;
import com.ds.ads.model.Region;
import com.ds.ads.model.User;
import com.ds.ads.services.LocationRepository;
import com.ds.ads.services.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=AdsApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class LoginCtrlTest {

    @Value("${local.server.port}")
    int port;
    
    @Autowired
    UserRepository userRep;
    
    @Autowired
    LocationRepository locationRep;
    
    private static Logger LOGGER = LoggerFactory.getLogger(LoginCtrlTest.class); 
    
    
    private static Country c;
    private static Region r;
    private static City city;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
	c = new Country();
	c.setCode("ru");
	c.setName("Russia");
	
	r = new Region();
	r.setCountry(c);
	r.setName("fucking region");
	
	city = new City();
	city.setRegion(r);
	city.setName("Fucking city");
	
    }
    
    @Before
    public void setUp(){
	RestAssured.port = port;
	userRep.deleteAll();
    }
    
    @Test
    public void itShouldRegisterNewUserWithoutLocation() throws JsonProcessingException {
	Map<String, Object> map = new HashMap<>();
	map.put("login", "valua");
	map.put("pass", "sobaka");
	map.put("name", "Vasyka");
	map.put("phones", new Phone[] {new Phone("812", "7773434")});
	
	long oldValue = userRep.count();
	
	ObjectMapper json = new ObjectMapper();
	String jsonString = json.writeValueAsString(map);
	
	LOGGER.info(jsonString);
	
	given().
		contentType(ContentType.JSON).
		body(jsonString).
	when().post("/api/login/register").
	then().statusCode(HttpStatus.SC_CREATED);
	
	assertThat("userRep count now +1", userRep.count(), equalTo(oldValue + 1));
    }
    
    @Test
    public void itShouldRegisterNewUserWithLocation() throws JsonProcessingException {
	Location loc = new Location();
	loc.setCity(city);
	loc.setAddress("fucking ad");
	loc = locationRep.save(loc);	
	
	//USER
	Map<String, Object> map = new HashMap<>();
	map.put("login", "valua");
	map.put("pass", "sobaka");
	map.put("name", "Vasyka");
	map.put("phones", new Phone[] {new Phone("812", "7773434")});
	map.put("name", "Vasyka");
	map.put("location", "http://localhost:8080/api/repo/location/" + loc.getId());
	
	long oldValue = userRep.count();
	
	ObjectMapper json = new ObjectMapper();
	String jsonString = json.writeValueAsString(map);
	
	LOGGER.info(jsonString);
	
	given().
		contentType(ContentType.JSON).
		body(jsonString).
	when().post("/api/login/register").
	then().statusCode(HttpStatus.SC_CREATED);
	
	assertThat("userRep count now +1", userRep.count(), equalTo(oldValue + 1));
	
	User uFromRepo = userRep.findByLogin((String) map.get("login"));
	Assert.notNull(uFromRepo, "new user in repo exists");
	Assert.notNull(uFromRepo.getLocation(), "new users location in repo exists");
	assertThat("location in repo equals to given location", uFromRepo.getLocation().equals(loc));
    }
    
    @Test
    public void testRegisterAgainReturnExeption() throws JsonProcessingException {
	User u = new User();
	u.setLogin("vasya123");
	u.setPass("sobaka");
	u.setName("Vasyka");
	u.getPhones().add(new Phone("812", "7773434"));
	
	long oldValue = userRep.count();
	
	ObjectMapper json = new ObjectMapper();
	String jsonString = json.writeValueAsString(u);
	LOGGER.debug(jsonString);
	
	given().
		contentType(ContentType.JSON).
		body(jsonString).
	when().post("/api/login/register").
	then().statusCode(HttpStatus.SC_CREATED);
	
	given().
        	contentType(ContentType.JSON).
        	body(jsonString).
        when().post("/api/login/register").
        then().statusCode(HttpStatus.SC_CONFLICT);
	
    }

}
