package com.travelxy.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelxy.userservice.models.User;
import com.travelxy.userservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
	
	public User findUserById(Long id) {
		return userRepo.getOne(id);
	}
	
	public User findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	
	public User createUser(User user) {
		return this.userRepo.saveAndFlush(user);
	}
	
	public void deleteUserById(Long id) {
		this.userRepo.deleteById(id);
	}
	
	public List<User> findAllUser() {
		return this.userRepo.findAll();
	}
}
