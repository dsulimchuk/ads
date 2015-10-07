package com.ds.ads.services;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ds.ads.model.User;

@RepositoryRestResource(path="/api/users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    
    User findByLogin(String login);
}
