package com.emre.springdemo.service.abstracts;

import java.util.List;

import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.core.utilities.results.service.DataResult;
import com.emre.springdemo.core.utilities.results.service.Result;

public interface UserService {
	DataResult<List<User>> findAll();
	DataResult<User> findByEmail(String email);
	Result add(User user);
	Result update(User user);
	Result delete(User user);
}
