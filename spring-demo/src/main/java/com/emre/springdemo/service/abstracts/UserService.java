package com.emre.springdemo.service.abstracts;

import java.util.List;

import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;

public interface UserService {
	DataResult<List<User>> findAll();
	DataResult<User> findByEmail(String email);
	Result add(User user);
	Result update(User user);
	Result delete(User user);
}
