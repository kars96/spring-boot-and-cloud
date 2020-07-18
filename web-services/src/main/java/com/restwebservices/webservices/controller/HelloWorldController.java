package com.restwebservices.webservices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// GET /helloworld
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<String>("Hello World!", HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Good night");
	}
	
	@GetMapping(path = "/hello-user/{nam}")
	public HelloWorldBean HelloUser(@PathVariable(name = "nam") String name) {
		return new HelloWorldBean(String.format("Hello %s", name));
	}
}
