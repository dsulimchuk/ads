package com.ds.ads;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
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

    public static void main(String[] args) {
	ApplicationContext ctx = SpringApplication.run(AdsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
	
    }
}
