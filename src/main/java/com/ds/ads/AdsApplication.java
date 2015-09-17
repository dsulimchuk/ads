package com.ds.ads;

import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.ds.ads.model.User;
import com.ds.ads.services.UserRepository;

@SpringBootApplication
//@ComponentScan(basePackages="com.ds.ads")
//@EnableWebMvc
//@EnableTransactionManagement
//@EnableJpaRepositories("com.ds.ads.model")
public class AdsApplication implements CommandLineRunner{

  @Autowired
  private UserRepository userRep;
    
    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(AdsApplication.class, args);
    	//Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    	
    	
    }

    @Override
    public void run(String... args) throws Exception {
	User user = new User();
	user.setName("ds");
	user.setLogin("ds1");
	user.setPass("pass");
	userRep.save (user);
	
    }
    
    @Bean
    public static DataSource dataSource() {
	System.out.println(Thread.currentThread().getStackTrace());
	DataSource dataSource = new DataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:mem:tratata");
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
//        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//        properties.setProperty("hibernate.show_sql", "true");
//        properties.setProperty("hibernate.format_sql", "true");
//        
        return properties;
    }
//    
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        transactionManager.setDataSource(dataSource());
//        return transactionManager;
//    }
    
}
