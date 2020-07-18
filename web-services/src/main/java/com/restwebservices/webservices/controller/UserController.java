package com.restwebservices.webservices.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restwebservices.webservices.models.User;
import com.restwebservices.webservices.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Get - /users
	@GetMapping(path = "/users")
	public List<User> getUsers() {
		return userService.getAll();
	}
	//Get - /users/{id}
	@GetMapping(path = "/users/{id}")
	public User getUserByID(@PathVariable Integer id) {
		return userService.findByID(id);
	}
	
	//Post - /users
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@RequestBody User u){
		User user = userService.saveUser(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(user.getId());
		return ResponseEntity.created(uri).build();
	}
	
}
