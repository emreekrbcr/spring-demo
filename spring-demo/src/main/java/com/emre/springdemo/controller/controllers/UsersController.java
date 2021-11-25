package com.emre.springdemo.controller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.service.abstracts.UserService;

@RestController
@RequestMapping("/controller/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
}
