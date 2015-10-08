package com.ds.ads;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ds.ads.model.City;
import com.ds.ads.model.Country;
import com.ds.ads.model.Location;
import com.ds.ads.model.Phone;
import com.ds.ads.model.Region;
import com.ds.ads.model.User;
import com.ds.ads.services.UserRepository;




@SpringBootApplication
//@ComponentScan(basePackages = "com.ds.ads")
//@EnableTransactionManagement
@EnableJpaRepositories("com.ds.ads")
public class AdsApplication implements CommandLineRunner{

    private static Logger logger = LoggerFactory.getLogger(AdsApplication.class);
    
    @Bean
    public static DataSource dataSource(DataSourceProperties dataSourceProperties) {
	DataSource ds = DataSourceBuilder.create(dataSourceProperties.getClassLoader())
		.driverClassName(dataSourceProperties.getDriverClassName())	
		.url(dataSourceProperties.getUrl())
		.username(dataSourceProperties.getUsername())
		.password(dataSourceProperties.getPassword())
		.build();
	return ds;	
    }    


    @Autowired
    private UserRepository ur;
    
    public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(AdsApplication.class, args);
	
	
    }

    @Override
    public void run(String... args) throws Exception {
	User u = new User();
	u.setLogin("ds");
	u.setName("name");
	u.setPass("hahah");
	
	
	u.getPhones().add(new Phone("821", "1234567"));
	u.getPhones().add(new Phone("821", "1234568"));
	
	Country c = new Country();
	c.setCode("ru");
	c.setName("Russia");
	
	Region r = new Region();
	r.setCountry(c);
	r.setName("fucking region");
	
	City city = new City();
	city.setRegion(r);
	city.setName("Fucking city");
	
	
	Location l = new Location();
	l.setCity(city);
	
	l.setAddress("Newvski prospect");
	
	
	u.setLocation(l);
	ur.save(u);
	
    }

    
    //
    // @Bean
    // public JpaTransactionManager transactionManager() {
    // JpaTransactionManager transactionManager = new JpaTransactionManager();
    // transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    // transactionManager.setDataSource(dataSource());
    // return transactionManager;
    // }

}
