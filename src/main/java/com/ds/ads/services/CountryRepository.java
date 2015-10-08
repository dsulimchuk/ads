package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.Country;

@RepositoryRestResource(path="country")
public interface CountryRepository extends CrudRepository<Country, Long>{

    public Country findByCode(@Param("code") String code);
}


