package com.construction.material.management.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.material.management.system.model.AdministrativeUser;
import com.construction.material.management.system.model.Login;
import com.construction.material.management.system.model.User;
import com.construction.material.management.system.service.AdministrativeUserService;
import com.construction.material.management.system.service.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdministrativeUserService administrativeUserService;
	
	@PostMapping
	public Object login(@RequestBody Login login) {
		
		String email = login.getEmail();
		String password = login.getPassword();
		
		List<AdministrativeUser> admins = administrativeUserService.getAllAdministrativeUsers();
        for (AdministrativeUser admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                // Successful login for administrative user
                return admin; // Return the logged-in administrative user details
            }
        }
        
        List<User> users = userService.getAllUsers();
        for(User user : users) {
        	if(user.getEmail().equals(email) && user.getPassword().equals(password)) {
        		return user;
        	}
        }
        
        return "Login failed: Invalid email or password";
		}

}
