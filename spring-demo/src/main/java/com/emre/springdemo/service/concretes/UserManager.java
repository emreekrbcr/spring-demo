package com.emre.springdemo.service.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emre.springdemo.core.dataAccess.UserDao;
import com.emre.springdemo.core.entities.User;
import com.emre.springdemo.core.utilities.constants.Messages;
import com.emre.springdemo.core.utilities.results.DataResult;
import com.emre.springdemo.core.utilities.results.Result;
import com.emre.springdemo.core.utilities.results.SuccessDataResult;
import com.emre.springdemo.core.utilities.results.SuccessResult;
import com.emre.springdemo.service.abstracts.UserService;

@Service
public class UserManager implements UserService {

	private final UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<User>> findAll() {
		List<User> users = userDao.findAll();
		return new SuccessDataResult<>(users, Messages.SystemMessages.OperationSucceeded);
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		User user = userDao.findByEmail(email);
		return new SuccessDataResult<>(user, Messages.SystemMessages.OperationSucceeded);
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult(Messages.SystemMessages.OperationSucceeded);
	}

	@Override
	public Result update(User user) {
		userDao.save(user);
		return new SuccessResult(Messages.SystemMessages.OperationSucceeded);
	}

	@Override
	public Result delete(User user) {
		userDao.delete(user);
		return new SuccessResult(Messages.SystemMessages.OperationSucceeded);
	}

}
