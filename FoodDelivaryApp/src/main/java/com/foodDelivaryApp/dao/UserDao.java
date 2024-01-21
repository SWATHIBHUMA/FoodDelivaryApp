package com.foodDelivaryApp.dao;

import java.util.List;
import com.foodDelivaryApp.model.User;

public interface UserDao {
	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	boolean UserExists(String username, String password);
}
