package com.ds.ads.configuration;

import java.net.URI;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class MyRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration {

    private static final String MY_BASE_URI_URI = "/api/repo/";

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBaseUri(URI.create(MY_BASE_URI_URI));
    }
}