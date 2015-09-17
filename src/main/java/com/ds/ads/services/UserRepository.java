package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;

import com.ds.ads.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    
    public User findById(long id);
    
}
