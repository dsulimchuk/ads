package com.ds.ads.backend;

import com.ds.ads.model.Country;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.util.List;

@SpringBootApplication
@EntityScan("com.ds.ads.model")
@EnableJpaRepositories("com.ds.ads")
public class AdsApplication implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(AdsApplication.class);

    public static class CountryKeeper {
        @JsonProperty("_embedded")
        private List<Country> countries;

        public List<Country> getCountries() {
            return countries;
        }

        public void setCountries(List<Country> countries) {
            this.countries = countries;
        }


    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(AdsApplication.class, args);
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource("/countries.sql"));
        resourceDatabasePopulator.addScript(new ClassPathResource("/regions.sql"));
        resourceDatabasePopulator.setContinueOnError(false);
        javax.sql.DataSource dataSource = ctx.getBean(javax.sql.DataSource.class);
        DatabasePopulatorUtils.execute(resourceDatabasePopulator, dataSource);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
