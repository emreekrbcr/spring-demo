package com.emre.springdemo.service.abstracts;

import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;

public interface UserService {
	DataResult<User> findByEmail(String email);
	Result add(User user);
	Result update(User user);
	Result delete(User user);
}
