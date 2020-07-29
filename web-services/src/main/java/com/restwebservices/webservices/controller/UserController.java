package com.restwebservices.webservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restwebservices.webservices.exceptions.UserNotFoundException;
import com.restwebservices.webservices.models.Post;
import com.restwebservices.webservices.models.User;
import com.restwebservices.webservices.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Get - /users
	@GetMapping()
	public List<User> getUsers() {
		List<User> users = userService.getAll();
		return users;
	}
	//Get - /users/{id}
	@GetMapping(path = "{id}")
	public User getUserByID(@PathVariable Integer id) {
		 User user = userService.findByID(id);
		 if(user == null) {
			 throw new UserNotFoundException("id: "+ id);
		 }
		 return user;
	}
	
	//Post - /users
	@PostMapping()
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User u){
		User user = userService.saveUser(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").build(user.getId());
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(path = "/{id}/posts")
	public ResponseEntity<List<Post>> getAllUserPosts(@PathVariable Integer id) {
		return new ResponseEntity<List<Post>>(this.userService.getUserPosts(id), HttpStatus.FOUND);
		
	}
	
	@PostMapping(path = "/{id}/posts/add")
	public ResponseEntity<Object> createUserPost(@PathVariable Integer id, @RequestBody Post p) {
		p = this.userService.createUserPost(id, p);
		URI uri = ServletUriComponentsBuilder.fromPath("/users/{id}/posts/{id}").build(id, p.getPostID());
		return ResponseEntity.created(uri).build(); 
	}
	
	@GetMapping(path = "/{id}/posts/{postid}")
	public ResponseEntity<Post> getUserPostById(@PathVariable Integer id, @PathVariable Long postid) {
		return new ResponseEntity(this.userService.getUserPostById(id, postid), HttpStatus.FOUND);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteuserByID(@PathVariable Integer id) {
		 User user = userService.deleteUserById(id);
		 
//		 return ResponseEntity.noContent();
	}
}
