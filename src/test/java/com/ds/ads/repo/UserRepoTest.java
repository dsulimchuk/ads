package com.ds.ads.repo;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ds.ads.AdsApplication;
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
    @Transactional
    public void setUp() throws Exception {
	//ur.deleteAll();
	uOld = new User();
	uOld.setLogin("ds");
	uOld.setName("name");
	uOld.setPass("hahah");
	
	uOld.getPhones().add(new Phone("821", "1234567"));
	uOld.getPhones().add(new Phone("821", "1234568"));
	
	Iterator<Location> locationIter = lr.findAll().iterator();
	Location l;
	if (locationIter.hasNext()) {
	    l = locationIter.next(); 
	} else  {
	    	l = new Location();
    		l.setCity(city);
    		l.setAddress("Newvski prospect");
	}
	uOld = ur.save(uOld);
	
	uOld.setLocation(l);
	uOld = ur.save(uOld);
	
    }

    
    @Test
    @Transactional
    public void testThatICanSaveUserManyTimes() {
	uOld = ur.save(uOld);
	uOld = ur.save(uOld);
	uOld = ur.save(uOld);
    }
    
    @Test
    public void testThatRecievedObjIsEqualsToOld() {
	User uNew = ur.findOne(uOld.getId());
	Assert.assertNotNull(uNew);
	Assert.assertEquals(uOld, uNew);
	ur.delete(uNew);
    }    
    
    @Test
    public void testThatRecievedObjAfterModifyNotEqToOld() {
	User uNew = ur.findOne(uOld.getId());
	Assert.assertNotNull(uNew);
	Assert.assertEquals(uOld, uNew);
	uNew.getPhones().add(new Phone("821", "1234569"));
	Assert.assertNotEquals(uOld, uNew);
	ur.delete(uNew);
    }   

}
