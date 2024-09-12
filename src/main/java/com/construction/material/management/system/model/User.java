package com.construction.material.management.system.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    
    @Column(name="Name", nullable=false)
    private String name;

    @Column(nullable = false)
    private String password; // Store hashed password

    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] profilePicture; // Store as BLOB
    
    private String role = "user";
    
    
    
  
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String username, String name, String password, String email, String phoneNumber,
			String address, byte[] profilePicture, String role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.profilePicture = profilePicture;
		this.role = role;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	public byte[] getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(byte[] profilePicture) {
		this.profilePicture = profilePicture;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}





    
}
