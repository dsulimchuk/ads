package com.ds.ads.configuration;

import java.net.URI;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.ds.ads.model.City;
import com.ds.ads.model.Country;
import com.ds.ads.model.Location;
import com.ds.ads.model.User;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    private static final String MY_BASE_URI_URI = "/api/repo/";

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBaseUri(URI.create(MY_BASE_URI_URI));
        config.exposeIdsFor(User.class, Location.class, Country.class, City.class);
    }
}