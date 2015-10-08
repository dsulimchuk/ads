package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.Region;

@RepositoryRestResource(path="region")
public interface RegionRepository extends CrudRepository<Region, Long> {

    
}
