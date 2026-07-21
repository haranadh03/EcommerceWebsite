package com.ecommerce.service;

import java.util.List;

import com.ecommerce.entity.User;

public interface UserService {
	User registerUser(User user);
	User getUserById(Long id);
	List<User> getAllUsers();
	User updateUser(Long id, User user);
	void deleteUser(Long id);
}
