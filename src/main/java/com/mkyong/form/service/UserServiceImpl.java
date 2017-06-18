package com.mkyong.form.service;

import com.mkyong.form.dao.UserDao;
import com.mkyong.form.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public void save(User user) {
		userDao.create(user);
	}

	@Override
	public void change(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(int id) {
		userDao.remove(id);
	}

	@Override
	public User find(Integer id) {
		return userDao.find(id);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}