package com.restwebservices.webservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restwebservices.webservices.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
