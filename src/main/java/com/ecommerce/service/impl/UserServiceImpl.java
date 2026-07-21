package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User registerUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		User existingUser = userRepository.findById(id).orElse(null);
		if(existingUser != null) {
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setPhone(user.getPhone());
			existingUser.setRole(user.getRole());
			existingUser.setEnabled(user.isEnabled());
			return userRepository.save(existingUser);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
}
