package com.restwebservices.webservices.models;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
//@JsonFilter("dobfilter")
@Entity
public class User {
	
	@Size(min = 4, message = "Name must be atleast 4 chars")
	@Size(max = 10, message = "Name must be atmost 10 chars")
	@ApiModelProperty(notes = "Name must be atleast 4 chars and atmost 10 chars",  required = true)
	private String name;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Past
	@ApiModelProperty(notes = "Date of Birth must be in the past")
	private Date dob;
	
	@OneToMany(mappedBy = "user")
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User(String name, Integer id, Date dob) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
	}
	
	public User(String name, Integer id, Date dob, List<Post> posts) {
		super();
		this.name = name;
		this.id = id;
		this.dob = dob;
		this.posts = posts;
	}

	public User() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}
