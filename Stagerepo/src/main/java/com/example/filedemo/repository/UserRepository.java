package com.example.filedemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.filedemo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	 public User findByUsername(String username);
}
