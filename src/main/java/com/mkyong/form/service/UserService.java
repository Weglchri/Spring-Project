package com.mkyong.form.service;

import com.mkyong.form.model.User;

import java.util.List;

public interface UserService {

	void save(User user);

	void change(User user);
	
	void delete(int id);

	User find(Integer id);

	List<User> findAll();
	
}