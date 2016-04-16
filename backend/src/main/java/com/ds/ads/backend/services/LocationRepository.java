package com.ds.ads.backend.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.Location;

@RepositoryRestResource()
public interface LocationRepository extends CrudRepository<Location, Long>{

}

