package com.ds.ads.configuration;

import java.net.URI;

import com.ds.ads.model.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    private static final String MY_BASE_URI_URI = "/api/repo/";

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBasePath(MY_BASE_URI_URI);
        config.exposeIdsFor(User.class, Region.class, Location.class, Country.class, City.class);
    }
}