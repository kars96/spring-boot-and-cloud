package com.restwebservices.webservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.restwebservices.webservices.exceptions.PostsNotFoundException;
import com.restwebservices.webservices.exceptions.UserNotFoundException;
import com.restwebservices.webservices.models.Post;
import com.restwebservices.webservices.models.User;
import com.restwebservices.webservices.repositories.UserRepository;

@Service
public class UserService {
	private static ArrayList<User> users;

	static {
		users = new ArrayList<User>();
		List<Post> p1 = new ArrayList<Post>();
		p1.add(new Post("Astronomy", "Study of space", 1));
		p1.add(new Post("Geology", "Study of earth", 2));
		List<Post> p2 = new ArrayList<Post>();
		p2.add(new Post("Onco", "x", 1));
		users.add(new User("karthik", 1, new Date(), p1));
		users.add(new User("kars", 2, new Date(), p2));
		users.add(new User("kk", 3, new Date()));

	}
	
	@Autowired
	private UserRepository userRepo;

	public List<User> getAll() {
		return userRepo.findAll();
	}

	public Optional<User> saveUser(User u) {
		u = userRepo.saveAndFlush(u);
		return Optional.of(u);
	}

	public Optional<User> findByID(Integer id) {
		return userRepo.findById(id);
	}

	public List<Post> getUserPosts(Integer id) {
		return userRepo.findById(id).get().getPosts();

	}


//	public Post getUserPostById(Integer id, Long pid) {
//		Optional<User> u = findByID(id);
//		if (u.isPresent()) {
//			Post p = getUserPostById(u, pid);
//			return p;
//		}
//		throw new UserNotFoundException("User " + id + " is not found");
//	}
//
//	public Post getUserPostById(User u, Long pid) {
//		return this.userRepo.findById(u.getId()).get().getPosts();
//	}

	public void deleteUserById(Integer id) {
		userRepo.deleteById(id);

	}
}
