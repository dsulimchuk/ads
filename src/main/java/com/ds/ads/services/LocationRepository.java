package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.Location;

@RepositoryRestResource(path="location")
public interface LocationRepository extends CrudRepository<Location, Long>{

}

