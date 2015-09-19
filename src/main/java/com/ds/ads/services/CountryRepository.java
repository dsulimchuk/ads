package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;

import com.ds.ads.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

    public Country findById(long id);
    
    public Country findByCode(String code);
}
