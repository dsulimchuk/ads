package com.ds.ads.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by ds on 14/11/15.
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        //TODO
        builder
//            .jdbcAuthentication()
                .inMemoryAuthentication()
                .withUser("user")
                .password("user1")
                .roles("USER");

    }

}
