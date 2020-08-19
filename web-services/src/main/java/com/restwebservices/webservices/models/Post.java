package com.restwebservices.webservices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Post {
	private String title;
	private String content;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postID;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonBackReference
	private User user;
	
	public User getUsers() {
		return user;
	}
	public void setUsers(User users) {
		this.user = users;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getPostID() {
		return postID;
	}
	public void setPostID(long postID) {
		this.postID = postID;
	}
	public Post(String title, String content, long postID) {
		super();
		this.title = title;
		this.content = content;
		this.postID = postID;
	}
	public Post() {
		super();
	}
	
	
	
}
