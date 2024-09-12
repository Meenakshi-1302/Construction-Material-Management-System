package com.construction.material.management.system.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.construction.material.management.system.model.User;
import com.construction.material.management.system.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public User createUser(@RequestParam("username")String username,
			@RequestParam("name") String name, @RequestParam("password") String password,@RequestParam("email") String email, 
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address, @RequestParam("profilePicture") MultipartFile profilePicture ) {
		try {
			byte[] profilePictureBytes = profilePicture.getBytes();
			
			User user = new User();
			user.setUsername(username);
			user.setName(name);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			user.setProfilePicture(profilePictureBytes);
			
			userService.saveUser(user);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
		user.setId(id);
		userService.updateUser(id, user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deleteUSer(@PathVariable Long id) {
		userService.deleteUserById(id);
	}

}
