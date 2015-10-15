package com.ds.ads;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ds.ads.model.City;
import com.ds.ads.model.Country;
import com.ds.ads.model.Location;
import com.ds.ads.model.Phone;
import com.ds.ads.model.Region;
import com.ds.ads.model.User;
import com.ds.ads.services.LocationRepository;
import com.ds.ads.services.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AdsApplication.class )
public class UserRepoTest {

    @Autowired    private UserRepository ur;
    @Autowired    private LocationRepository lr;
    private static Country c;
    private static Region r;
    private static City city;
    
    
    
    private User uOld = null;
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
    public void setUp() throws Exception {
	ur.deleteAll();
	uOld = new User();
	uOld.setLogin("ds");
	uOld.setName("name");
	uOld.setPass("hahah");
	
	uOld.getPhones().add(new Phone("821", "1234567"));
	uOld.getPhones().add(new Phone("821", "1234568"));
	
	Location l = new Location();
	l.setCity(city);
	l.setAddress("Newvski prospect");
	
	uOld.setLocation(l);
    }

    @Test
    public void testThatUserIdIsNotNullAfterSave() {
	Assert.assertNotNull(uOld);
	Assert.assertNull(uOld.getId());
	ur.save(uOld);
	Assert.assertNotNull(uOld.getId());
    }
    
    @Test
    public void testThatICanSaveUserManyTimes() {
	ur.save(uOld);
	ur.save(uOld);
	ur.save(uOld);
	
    }
    
    @Test
    public void testThatRecievedObjIsEqualsToOld() {
	ur.save(uOld);
	User uNew = ur.findOne(uOld.getId());
	Assert.assertNotNull(uNew);
	
    }    
    
    @After
    public void SetDown(){
//	ur.deleteAll();
    }

}
