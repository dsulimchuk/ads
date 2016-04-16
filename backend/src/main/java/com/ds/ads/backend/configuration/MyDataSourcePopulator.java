package com.ds.ads.backend.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class MyDataSourcePopulator {
    
    @Autowired private DataSourceProperties dataSourceProperties;
    
    @Bean
    public DataSource dataSource() {
	DataSource ds = DataSourceBuilder.create(dataSourceProperties.getClassLoader())
		.driverClassName(dataSourceProperties.getDriverClassName())	
		.url(dataSourceProperties.getUrl())
		.username(dataSourceProperties.getUsername())
		.password(dataSourceProperties.getPassword())
		.build();
	return ds;	
    }   
    

}
