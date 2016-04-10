package com.ds.ads.services;

import com.ds.ads.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.Region;

import java.util.List;

@RepositoryRestResource()
public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    List<Region> findByCountryId(@Param("countryId") Long countryId);
    
}
