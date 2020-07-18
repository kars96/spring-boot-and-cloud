package com.restwebservices.webservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restwebservices.webservices.models.User;

@Component
public class UserService {
	private static ArrayList<User> users;
	
	static {
		users = new ArrayList<User>();
		users.add(new User("karthik", 1, new Date()));
		users.add(new User("kars", 2, new Date()));
		users.add(new User("kk", 3, new Date()));
		
	}
	
	public List<User> getAll() {
		return users;
	}
	
	public User saveUser(User u) {
		u.setId(users.size()+1);
		users.add(u);
		return u;
	}
	
	public User findByID(Integer id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
