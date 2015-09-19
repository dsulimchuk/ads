package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;

import com.ds.ads.model.Phone;

public interface PhonesRepository extends CrudRepository<Phone, Long>{

    public Phone findById(long id);
}
