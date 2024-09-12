package com.construction.material.management.system.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.material.management.system.model.User;
import com.construction.material.management.system.repository.UserRepository;
import com.construction.material.management.system.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findById(id);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {
		 userRepository.delte(id);
		
	}

	@Override
	public User updateUser(Long id, User user) {
		if (userRepository.findById(id) != null) {
			user.setId(id);
		return userRepository.update(user);
	}
	return null;
	}
	

}
