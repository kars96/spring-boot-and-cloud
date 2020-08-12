package com.travelxy.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelxy.userservice.models.User;
import com.travelxy.userservice.service.UserService;

@RestController()
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	@GetMapping()
	public ResponseEntity<List<User>> findAllUsers() {
		return ResponseEntity.ok(this.userServ.findAllUser());
	}
	
	
	@GetMapping("username/{username}")
	public ResponseEntity<?> findUserByUserName(@PathVariable() String username) {
		User user = this.userServ.findUserByUsername(username);
		if(user != null) {
			return  ResponseEntity.of(Optional.of(user));			
		} 
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping()
	public void createUser(@RequestBody() User user) {
		this.userServ.createUser(user);
	}
}
