package com.weenko.pbx.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.weenko.pbx.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByUsername(String username);
}
