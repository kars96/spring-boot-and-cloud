package com.restwebservices.webservices.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restwebservices.webservices.exceptions.PostsNotFoundException;
import com.restwebservices.webservices.exceptions.UserNotFoundException;
import com.restwebservices.webservices.models.Post;
import com.restwebservices.webservices.models.User;

@Component
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

	public List<User> getAll() {
		return users;
	}

	public User saveUser(User u) {
		u.setId(users.size() + 1);
		users.add(u);
		return u;
	}

	public User findByID(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public List<Post> getUserPosts(Integer id) {
		User u = findByID(id);
		if (u != null) {
			return u.getPosts();
		}
		throw new UserNotFoundException("User " + id + " is not found");

	}

	public Post createUserPost(Integer id, Post post) {
		User u = findByID(id);
		if (u != null) {
			if (u.getPosts() == null) {
				u.setPosts(new ArrayList<Post>());
			}
			post.setPostID(u.getPosts().size());
			System.out.println(u.getPosts().toString());
			if (u.getPosts() != null) {
				u.getPosts().add(post);
			}
			return post;
		}
		throw new UserNotFoundException("User " + id + " is not found");
	}

	public Post getUserPostById(Integer id, Long pid) {
		User u = findByID(id);
		if (u != null) {
			Post p = getUserPostById(u, pid);
			return p;
		}
		throw new UserNotFoundException("User " + id + " is not found");
	}

	public Post getUserPostById(User u, Long pid) {
		for (Post p : u.getPosts()) {
			if (p.getPostID() == pid) {
				return p;
			}
		}
		throw new PostsNotFoundException("User " + u.getId() + " has no post " + pid);
	}

	public User deleteUserById(Integer id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		throw new UserNotFoundException("User " + id + " is not found");

	}
}
