package com.ds.ads;

import java.util.Properties;
import java.util.stream.IntStream;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.ds.ads.model.Phone;
import com.ds.ads.model.User;
import com.ds.ads.services.PhonesRepository;
import com.ds.ads.services.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages = "com.ds.ads")
// @EnableTransactionManagement
// @EnableJpaRepositories("com.ds.ads.model")
public class AdsApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private PhonesRepository phonesRep;

    public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(AdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	
	
//	// test fill users
	IntStream.rangeClosed(0, 100).forEach(idx -> {
	    User user = new User();
	    user.setName("ds_" + idx);
	    user.setLogin("ds_" + idx);
	    user.setPass("pass" + idx);
	    Phone phone1 = new Phone("812", Integer.valueOf(idx).toString());
	    user.addPhone(phone1);
	    userRep.save(user);

	});

	// userRep.delete(user.getId());

    }

    @Bean
    public static DataSource dataSource() {
	DataSource dataSource = new DataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
	return dataSource;
    }

    @Bean
    public static LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	entityManagerFactoryBean.setDataSource(dataSource());
	entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	entityManagerFactoryBean.setPackagesToScan("com.ds.ads.model");
	entityManagerFactoryBean.setJpaProperties(jpaProperties());
	return entityManagerFactoryBean;
    }

    private static Properties jpaProperties() {
	Properties properties = new Properties();
	properties.getProperty("jpa.properties");
	System.out.println("!!!!!" + properties.toString());
	properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
	properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.setProperty("hibernate.show_sql", "true");
	properties.setProperty("hibernate.format_sql", "true");
	//
	return properties;
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
