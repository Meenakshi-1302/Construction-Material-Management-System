package com.construction.material.management.system.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="materialId")
	private Material material;
	
	@ManyToOne
	@JoinColumn(name="inventoryId")
	private Inventory inventory;
	
	@Column(name="Amount")
	private double amount;
	
	@Column(name="Date")
	private LocalDateTime date;
	
	@Column(name="Payment Method")
	private String paymentMethod;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(long paymentId, User user, Material material, Inventory inventory, double amount,
			LocalDateTime date, String paymentMethod) {
		super();
		this.paymentId = paymentId;
		this.user = user;
		this.material = material;
		this.inventory = inventory;
		this.amount = amount;
		this.date = date;
		this.paymentMethod = paymentMethod;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
	

}
