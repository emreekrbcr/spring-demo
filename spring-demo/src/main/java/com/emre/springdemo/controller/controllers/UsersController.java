package com.emre.springdemo.controller.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.core.utilities.controller.ControllerHelper;
import com.emre.springdemo.core.utilities.results.service.DataResult;
import com.emre.springdemo.core.utilities.results.service.Result;
import com.emre.springdemo.service.abstracts.UserService;

@RestController
@RequestMapping("/controller/users")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		DataResult<List<User>> dataResult = userService.findAll();
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	@GetMapping("/findByEmail/{email}")
	public ResponseEntity<?> findByEmail(@PathVariable(value = "email") String email) {
		DataResult<User> dataResult=userService.findByEmail(email);
		return ControllerHelper.returnCommonResponseModel(dataResult);
	}

	// @Valid annotation'ı koy, yoksa validation hata yönetiminde sıkıntı oluyor
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		Result result=userService.add(user);
		return ControllerHelper.returnCommonResponseModel(result);
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody User user) {
		Result result=userService.update(user);
		return ControllerHelper.returnCommonResponseModel(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody User user) {
		Result result=userService.delete(user);
		return ControllerHelper.returnCommonResponseModel(result);
	}

}
