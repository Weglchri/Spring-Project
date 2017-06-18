package com.mkyong.form.dao;

import com.mkyong.form.model.User;

import java.util.List;

public interface UserDao {

	void create(User user);

	void update(User user);

	void remove(Integer id);

	User find(Integer id);

	List<User> findAll();

}