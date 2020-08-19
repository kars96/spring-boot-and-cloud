package com.restwebservices.webservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.restwebservices.webservices.exceptions.UserNotFoundException;
import com.restwebservices.webservices.models.Post;
import com.restwebservices.webservices.models.User;
import com.restwebservices.webservices.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Get - /users
	@GetMapping()
	public List<User> getUsers() {
		List<User> users = userService.getAll();
		return users;
	}

//	@GetMapping("/filter") 
//	public MappingJacksonValue getUsersExcludingDob() {
//		List<User> users = userService.getAll();
//
//		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
//		FilterProvider filters = new SimpleFilterProvider().addFilter("dobfilter", filter );
//		MappingJacksonValue mapping = new MappingJacksonValue(users);
//		mapping.setFilters(filters );
//		
//		return mapping;
//	}

	// Get - /users/{id}
	@GetMapping(path = "{id}")
	public Optional<User> getUserByID(@PathVariable Integer id) {
		Optional<User> user = userService.findByID(id);
		if (user == null) {
			throw new UserNotFoundException("id: " + id);
		}
		return user;
	}

	// Post - /users
	@PostMapping()
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User u) {
		Optional<User> user = userService.saveUser(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(user.get().getId());
		return ResponseEntity.created(uri).build();
	}

	@GetMapping(path = "/{id}/posts")
	public ResponseEntity<List<Post>> getAllUserPosts(@PathVariable Integer id) {
		return new ResponseEntity<List<Post>>(this.userService.getUserPosts(id), HttpStatus.FOUND);

	}
//
//	@PostMapping(path = "/{id}/posts/add")
//	public ResponseEntity<Object> createUserPost(@PathVariable Integer id, @RequestBody Post p) {
//		p = this.userService.createUserPost(id, p);
//		URI uri = ServletUriComponentsBuilder.fromPath("/users/{id}/posts/{id}").build(id, p.getPostID());
//		return ResponseEntity.created(uri).build();
//	}

	@DeleteMapping(path = "{id}")
	public void deleteuserByID(@PathVariable Integer id) {
		userService.deleteUserById(id);

//		 return ResponseEntity.noContent();
	}
}
