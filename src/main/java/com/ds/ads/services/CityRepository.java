package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.City;

@RepositoryRestResource()
public interface CityRepository extends CrudRepository<City, Long>{

}
