package com.ds.ads.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.User;

@RepositoryRestResource(exported=false)
public interface UserRepository extends CrudRepository<User, Long> {
    
    User findByLogin(String login);
}
