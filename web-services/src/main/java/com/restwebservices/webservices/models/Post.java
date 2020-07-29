package com.restwebservices.webservices.models;

public class Post {
	private String title;
	private String content;
	private long postID;
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
