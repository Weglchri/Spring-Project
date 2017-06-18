package at.fhj.swd.dao;

import at.fhj.swd.model.User;

import java.util.List;

public interface UserDao {

	void create(User user);

	void update(User user);

	void remove(Integer id);

	User find(Integer id);

	List<User> findAll();

}