package com.construction.material.management.system.service;

import java.util.List;

import com.construction.material.management.system.model.User;

public interface UserService {
	
	User saveUser(User user);
	User getUserById(Long id);
	List<User> getAllUsers();
	void deleteUserById(Long id);
	User updateUser(Long id, User user);
	
	

}
