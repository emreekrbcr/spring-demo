package com.emre.springdemo.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.springdemo.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	//değişiklik olsun diye find tercih ettik, get ya da find fark etmez ama tüm projede standart olsun
	User findByEmail(String email);
}
