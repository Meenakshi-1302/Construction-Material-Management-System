package com.construction.material.management.system.model;

public class Login {
	private String email;
    private String password;
    
    
 
    public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
    

	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	// Getters and Setters
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

}
